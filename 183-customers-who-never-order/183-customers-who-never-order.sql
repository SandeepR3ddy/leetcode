# Write your MySQL query statement below
SELECT c.name as 'Customers' from
Customers c 
where c.id not in
(
  select customerid from orders
);