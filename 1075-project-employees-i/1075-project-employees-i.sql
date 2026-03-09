/* Write your PL/SQL query statement below */
select p.project_id, Round(AVG(e.experience_years),2) average_years
from Project p 
left join Employee e 
on p.employee_id = e.employee_id
group by p.project_id