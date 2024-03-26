show tables;

create table insa2 (
	idx int not null auto_increment primary key,		/* 고유번호 */
	name varchar(20) not null,		/* 성명 */
	age int default 20,		/* 나이 */
	gender char(2) default '여자',		/* 성별 */
	ipsail datetime default now()		/* 입사일 */
);

desc insa2;
drop table insa2;

insert into insa2 values (default, '김말숙',default,default,default);
insert into insa2 values (default, '홍길동',default,'남자',default);
insert into insa2 (name) values ('오하늘'); /* 이름 외 나머지를 default, 이름만 따로 입력 */

select * from insa2;