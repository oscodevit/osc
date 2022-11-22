#!/bin/bash
read -p "Enter number : " n
for(( i=2; i<=$n/2; i++))
do
    ans=$(( n%i ))
    if [ $ans -qu 0 ]
    then
        echo "$n is not a prime number."
        read x
        exit 0
    fi
done
echo "$n is a prime number"
read X