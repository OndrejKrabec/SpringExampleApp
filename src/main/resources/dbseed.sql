CREATE TABLE public.users (
                              id int4 DEFAULT nextval('user_sq'::regclass) NOT NULL,
                              "name" varchar(30) NULL,
                              username varchar(30) NOT NULL,
                              "password" varchar(30) NOT NULL,
                              CONSTRAINT users_pk PRIMARY KEY (id),
                              CONSTRAINT users_unique UNIQUE (username)
);
INSERT INTO public.users ("name", username, "password") VALUES
                                                            ('Alice Johnson', 'alicej', 'pass123'),
                                                            ('Bob Smith', 'bobsmith', 'bob2021'),
                                                            ('Carol Davis', 'carold', 'securepass'),
                                                            ('David Miller', 'davidm', 'davidpw'),
                                                            ('Eve Carter', 'evec', 'evepass');
