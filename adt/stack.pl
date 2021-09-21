use strict;
# Using stack in Perl

my @st;

print "\nPushing element 20";
push @st, 20;

print "\nPushing element -2";
push @st, -2;


print "\nPushing element 5";
push @st, 5;

print "\nTop element in stack is @st[$#st]";

my $top = pop @st;
print "\nPop top element $top";

my $top = pop @st;
print "\nPop top element $top";

print "\nTop element in stack is @st[$#st]";


print "\nPushing element 100";
push @st, 100;

print "\nStack is @st";
