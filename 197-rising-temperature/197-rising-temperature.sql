SELECT a.Id 
FROM Weather a join Weather b
on a.Temperature > b.Temperature
AND DATEDIFF(a.Recorddate,b.Recorddate) = 1