LegislatureSQL
==============

Project to set up interchange software between the JSON data provided by the OpenStates project and an SQL database, in this case MySQL.

Well, first, I am going to add the code I use to read the CA legislative information out of the state web site and the code that I use to
generate data in MySQL tables to store information from the HTML files that are put out by the legilative.

The OpenStates project uses the MySQL database exported by the CA LAO. I think there are problems with that database. They do not expose
all of it (as far as I can tell) and the HTML files actually give a more easily parsable version of the data. Their database contains
some very odd XML that seems to come from SharePoint. I think the OpenStates just ignores this data. This allows them to get to the
simple data easily, but does not expose the whole story.

I think I may be able to use the HTML files to put data into a MySQL database and I think that I can product, from that, JSON data which
may be more complete than the data that the OpenStates processing comes up with. We will see.

For now, I am not worrying about how documented this is. Mostly I want to not lose this code again.

Note: The script relies on a file in your home directory, named .leg_sql_options.txt, which contains:

    db <name of your MySQL database>
    user <username for your MySQL user>
    pwd <password for your MySQL user>
    session <default session, eg 11-12 or 13-14>

-rrk 2012/11/17

Contents:
---------

    00_createTables - creates the tables used here.

    01_downloadNewBillFiles - downloads the html files (not pdf) from the leginfo site.

    02_importBills - puts bill information from the status files into a table.

    03_importVersions - put entries for the various bill versions into the database.

    04_connectSections - connect the bills to the sections of CA law that they affect.

    05_updateStatusDate - from the latest status file.

    cmds.pl - helper subroutines.

Still To Do:
------------

00_createTables.sql:# TODO the table create commands can first determine if a table exists. Since I am not dropping tables, this is ok for now.

I have file_location and file_date columns in the bill. This is not correct. Actually, each chamber has a file, which is its own thing. Bills are put
in the file and they get a number. I need to keep track of the date something was added to the file and its number in the file. But it probably
makes sense that the file would be its own entity. I just need to work out what it looks like.

The author and authorings stuff needs to be done.

I have some information associated with the bill that needs to come out of it. This may be painful, because the status and history file make it look as
though some of this is associated with the bill and not the file. For example, the title, topic and list of authors. An author is not an author of a
bill. An author is an author of a version of the bill. So, the topic, title and authors are not modifiable attributes of the bill. They are invariant
attributes of the bill version. But, for ease of access, I will need to link the bill to its latest version explicitly and I may need a reverse marker
on the bill version.

I have started this process, but there are issues. For example, the meta-data fro the bill_version contains the title but it only contains the first
45 characters of it. They hand-wave on the rest. This is wrong, but o well. If I want to keep the title in the bill_version, I will have to either get
it out of the status file, which only lasts while that version is latest (very bad), or I will have to get it out of the bill text (ugly). O well.

