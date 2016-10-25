use exercicios
go

/* 
7) Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
*/
Select emp.NomeEmpregado, 
       ger.NomeEmpregado as NomeGerente,
	   de.NomeDepartamento as DepartamentoEmpregado,
	   dg.NomeDepartamento as DepartamentoGerente
From   Empregado emp
  inner join Empregado ger on emp.IDGerente = ger.IDEmpregado
  inner join Departamento de on de.IDDepartamento = emp.IDDepartamento
  inner join Departamento dg on dg.IDDepartamento = ger.IDDepartamento;


/* 8) Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) 
que o departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
*/
Select *
Into   CopiaEmpregado
From   Empregado;

begin transaction

Update Empregado
set    Salario = Salario * 1.145
where  exists (select 1
               from   departamento
			   where  departamento.IDDepartamento = Empregado.IDDepartamento
			   and    departamento.Localizacao    = 'Sao Paulo');

/*
9) Liste a diferença  que representará o reajuste aplicado no item anterior 
no somatório dos salários de todos os empregados.
*/	
select sum(CopiaEmpregado.salario) as ValorAnterior ,
       sum(Empregado.salario) as ValorNovo,
	   sum(Empregado.salario) - sum(CopiaEmpregado.salario) as Diferenca
from   CopiaEmpregado
  inner join Empregado on CopiaEmpregado.IDEmpregado = Empregado.IDEmpregado;

/*
10) Liste o departamento com o empregado de maior salário.
*/
Select IDDepartamento, NomeDepartamento
From   Departamento dep
Where  exists (select 1
               from   Empregado emp
			   Where  emp.IDDepartamento = dep.IDDepartamento
			   and    emp.Salario        = (select max(Salario)
			                                from   empregado
											where  IDDepartamento is not null) -- prevendo que o departamento seja informado
			   );