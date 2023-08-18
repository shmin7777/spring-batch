#!/bin/sh

echo "mysql dump batch luanch!!"


mysqldump -u root -p 1234 -h localhost:3306 > exportFile.sql

echo "dump success"


