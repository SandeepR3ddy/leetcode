# Write your MySQL query statement below
SELECT lastName,firstName, state, city
FROM Person LEFT JOIN Address
on Person.personId = Address.personId;