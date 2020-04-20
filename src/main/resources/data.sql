INSERT INTO users (id, email, password, username) VALUES
  (1, 'admin', '$2y$12$iuiBzHEAELeAHheWIhcXQ.TyPU7jW9HGpyhjT2HebhProGvAc.eWK', 'admin'),
  (2, 'user', '$2y$12$bTxU523PnPV5sI6bfqjm.uDtqS1UD0i61mwEC.lTR15zAQKwcYWaO', 'user');
  
INSERT INTO roles (id, name) VALUES
  (1, 'ADMIN'),
  (2, 'USER');
  
INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 1),
  (2, 2);
