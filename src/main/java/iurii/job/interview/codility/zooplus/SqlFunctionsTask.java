package iurii.job.interview.codility.zooplus;

/**
 *
 *

 create table department (
 dept_id integer not null,
 dept_name varchar(30) not null,
 dept_location varchar(30) not null,
 unique(dept_id)
 );

 create table employee (
 emp_id integer not null,
 emp_name varchar(50) not null,
 dept_id integer not null,
 salary integer not null,
 unique(emp_id)
 );


 insert into department values(10, 'Accounts', 'Delhi');
 insert into department values(20, 'Marketing', 'Delhi');
 insert into department values(40, 'IT', 'Warsaw');
 insert into department values(30, 'Production', 'Hyderabad');
 insert into department values(50, 'Sales', 'Bengaluru');
 insert into employee values(1, 'Jojo', 20, 5000);
 insert into employee values(2, 'Popat Lal', 30, 15000);
 insert into employee values(3, 'Santa Singh', 40, 25000);
 insert into employee values(4, 'Banta Singh', 20, 7500);
 insert into employee values(5, 'Sohan Lal', 20, 15000);
 insert into employee values(6, 'Kk', 10, 12000);
 insert into employee values(7, 'Bob', 20, 35000);
 insert into employee values(8, 'John', 30, 25000);
 insert into employee values(9, 'Smith', 40, 5000);

 Answer:

 select d.dept_id, count (*), sum(e.salary) from employee e
 join department d on e.dept_id = d.dept_id
 group by d.dept_id
 order by d.dept_id asc;

 https://codility.com/public-link/zooplus-AG-Java-Engineering-2016/
 * Created by IuriiDziuban on 10/22/17.
 */
public class SqlFunctionsTask {
    //
}
