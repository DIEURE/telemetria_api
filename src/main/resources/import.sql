INSERT INTO PUBLIC.TB_EMPRESA(id, fantasia) VALUES (1,'DOL EMPREENDIMENTOS')


INSERT INTO public.tb_usuarios( empresa_id, id, email, nome, senha)	VALUES (1, 1,  'dieure@gmail.com', 'dieure','123456');
INSERT INTO public.tb_usuarios( empresa_id, id, email, nome, senha)	VALUES (1, 2,  'MARCOSe@gmail.com', 'dieure','123456');
INSERT INTO public.tb_usuarios( empresa_id, id, email, nome, senha)	VALUES (1, 3,  'lais@gmail.com', 'dieure','123456');


INSERT INTO public.tb_acesso(usuario_id, tipo_acesso)	VALUES (1, 0);
INSERT INTO public.tb_acesso(usuario_id, tipo_acesso)	VALUES (2, 0);
INSERT INTO public.tb_acesso(usuario_id, tipo_acesso)	VALUES (3, 1);
