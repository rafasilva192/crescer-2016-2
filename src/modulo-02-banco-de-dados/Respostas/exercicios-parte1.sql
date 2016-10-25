use exercicios
/* 
Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. 
1) Exibir também o total de meses de trabalho até a data de 31/12/2000.
*/
Select NomeEmpregado, 
       DataAdmissao,
	   DateDiff(month, DataAdmissao, convert(datetime, '31/12/2000', 103) ) meses_trabalho
From   Empregado
Where  DataAdmissao between convert(datetime, '01/05/1980', 103) 
                        and convert(datetime, '20/01/1982', 103) ;



/* 2) Qual o cargo (tabela empregado) tem mais empregados?
*/
Select top 1 WITH TIES
       Cargo,
       Count(1) total_Empregados
From   Empregado
Group  by Cargo
Order  by total_empregados desc;


/*
3) Liste a quantidade de cidades agrupando por UF 
– quantas cidades cada estado possuí ?
*/	
Select UF,
       Count(1) total_cidades
From   Cidade
group  by UF;

/*
4) Liste as cidades que possuem o mesmo nome e UF 
– cidades duplicadas.
*/

Select Nome, UF, count(1) total
From   Cidade
Group  by Nome , UF
Having count(1) > 1;

/*
5) Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado
 (maior + 1).
*/
Select isnull(max(idassociado),0) + 1 as Proximo_ID
from   associado;

/*
6) Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de Renda, considerando a tabela abaixo:
Até R$ 1.164,00 = 0%	De R$ 1.164,00 a R$ 2.326,00 = 15%
Acima de R$ 2.326,00 = 27,5%.
*/
Select NomeEmpregado,
       Salario,
	   Case when Salario <= 1164 then 0
	        when Salario <= 2336 then 15
			else 27.5
	   End Perc_IR
From   Empregado;


