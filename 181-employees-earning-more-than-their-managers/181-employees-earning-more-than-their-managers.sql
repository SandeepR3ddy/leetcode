select e.name as 'Employee'
from Employee as e JOIN Employee as b 
on e.managerId = b.id
and e.salary > b.salary