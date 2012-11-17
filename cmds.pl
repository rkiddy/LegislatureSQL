

sub mysql { return "/opt/local/bin/mysql -u ".$options{"user"}." --password=".$options{"pwd"}." --skip-column-names ".$options{"db"}."\n"; }

sub readOptions {
    local %options;
    open F, $ENV{"HOME"}."/.leg_sql_options.txt";
    while (<F>) {
        chomp;
        ($key, $val) = split ' ', $_;
        $options{$key} = $val;
    }
    close F;
    return %options;
}

sub doCmdResults {
    my @results = `$_[0]`;
    chomp(@results);
    return @results;
}

sub doSqlResults {
    $cmd = "echo \"".$_[0]."\" | ".&mysql;
    my @results = `$cmd`;
    chomp(@results);
    return @results;
}

sub doCmdResult {
    my $result = `$_[0]`;
    chomp($esult);
    return $result;
}

sub doSqlResult {
    my $cmd = "echo \"".$_[0]."\" | ".&mysql;
    my $result = `$cmd`;
    chomp($result);
    return $result;
}

1;
