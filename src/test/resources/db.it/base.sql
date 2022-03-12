insert into nivel(id, descricao)
values ('c43e6d21-2733-4cbb-95f5-6189f73f1dcb', 'Junior'),
       ('e57b2ced-8866-4d3f-9eda-1487f9d727b3', 'Pleno'),
       ('4f9c1877-efd9-44cf-95d3-e12b659db8da', 'Senior');

insert into desenvolvedor(id, nivel_id, nome, sexo, data_nascimento, idade, hobby)
values ('c43e6d21-2733-4cbb-95f5-6189f73f1dcb', '4f9c1877-efd9-44cf-95d3-e12b659db8da', 'João', 'MASCULINO', '1993-01-01', 28, 'Nada...'),
       ('e57b2ced-8866-4d3f-9eda-1487f9d727b3', '4f9c1877-efd9-44cf-95d3-e12b659db8da', 'Vivi', 'FEMININO', '1997-01-01', 25, 'Nada...'),
       ('4f9c1877-efd9-44cf-95d3-e12b659db8da', '4f9c1877-efd9-44cf-95d3-e12b659db8da', 'Miguel', 'MASCULINO', '1993-12-01', 28, 'Nada...');

