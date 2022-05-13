# Write your MySQL query statement below

SELECT email from Person p
GROUP BY email
HAVING COUNT(email) > 1;
