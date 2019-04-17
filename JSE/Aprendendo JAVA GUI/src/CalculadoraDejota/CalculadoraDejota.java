package CalculadoraDejota;

@SuppressWarnings("serial")
public class CalculadoraDejota extends javax.swing.JFrame {

	    public CalculadoraDejota() {
	        initComponents();
	    }
	    float resultado;
	    float num;
	    
	    int operador = 0;	    
	    /* 
	     * 1 = +
	     * 2 = -
	     * 3 = *
	     * 4 = /
	     * 5 = expoente.
	     * 6 = raiz.
	     */
	     void calcular(float num01, float num02){	    	
	    	switch (operador) {
			case 1:	resultado = num01+num02;		break;
			case 2:	resultado = num01-num02;		break;
			case 3:	resultado = num01*num02;		break;
			case 4:	resultado = num01/num02;		break;
			case 5:	resultado = (float) Math.pow(num01, num02);		break;
			case 6:	resultado = (float) Math.pow(num01, (1/num02));	break;
			default:break;
			}
	    	
	    }
	                      
	    private void initComponents() {

	        visor = new javax.swing.JTextField();
	        jPanel1 = new javax.swing.JPanel();
	        ADICAO = new javax.swing.JButton();
	        SUBRITACAO = new javax.swing.JButton();
	        MULTIPLICACAO = new javax.swing.JButton();
	        DIVISAO = new javax.swing.JButton();
	        BACKSPACE = new javax.swing.JButton();
	        CINCO = new javax.swing.JButton();
	        SEIS = new javax.swing.JButton();
	        SETE = new javax.swing.JButton();
	        OITO = new javax.swing.JButton();
	        NOVE = new javax.swing.JButton();
	        ZERO = new javax.swing.JButton();
	        UM = new javax.swing.JButton();
	        DOIS = new javax.swing.JButton();
	        TRES = new javax.swing.JButton();
	        QUATRO = new javax.swing.JButton();
	        LIMPAR = new javax.swing.JButton();
	        RAIZ = new javax.swing.JButton();
	        EXPOENTE = new javax.swing.JButton();
	        VIRGULA = new javax.swing.JButton();
	        IGUAL = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setResizable(false);

	        visor.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N

	        jPanel1.setLayout(new java.awt.GridLayout(4, 5, 5, 5));

	        ADICAO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        ADICAO.setText("+");
	        ADICAO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                ADICAOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(ADICAO);

	        SUBRITACAO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        SUBRITACAO.setText("-");
	        SUBRITACAO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SUBRITACAOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(SUBRITACAO);

	        MULTIPLICACAO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        MULTIPLICACAO.setText("*");
	        MULTIPLICACAO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                MULTIPLICACAOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(MULTIPLICACAO);

	        DIVISAO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        DIVISAO.setText("/");
	        DIVISAO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                DIVISAOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(DIVISAO);

	        BACKSPACE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        BACKSPACE.setText("BackSpace");
	        BACKSPACE.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                BACKSPACEActionPerformed(evt);
	            }
	        });
	        jPanel1.add(BACKSPACE);

	        CINCO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        CINCO.setText("5");
	        CINCO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                CINCOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(CINCO);

	        SEIS.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        SEIS.setText("6");
	        SEIS.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SEISActionPerformed(evt);
	            }
	        });
	        jPanel1.add(SEIS);

	        SETE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        SETE.setText("7");
	        SETE.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                SETEActionPerformed(evt);
	            }
	        });
	        jPanel1.add(SETE);

	        OITO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        OITO.setText("8");
	        OITO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                OITOActionPerformed(evt);
	            }
	        });
	        jPanel1.add(OITO);

	        NOVE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        NOVE.setText("9");
	        NOVE.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                NOVEActionPerformed(evt);
	            }
	        });
	        jPanel1.add(NOVE);

	        ZERO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        ZERO.setText("0");
	        ZERO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                ZEROActionPerformed(evt);
	            }
	        });
	        jPanel1.add(ZERO);

	        UM.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        UM.setText("1");
	        UM.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                UMActionPerformed(evt);
	            }
	        });
	        jPanel1.add(UM);

	        DOIS.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        DOIS.setText("2");
	        DOIS.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                DOISActionPerformed(evt);
	            }
	        });
	        jPanel1.add(DOIS);

	        TRES.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        TRES.setText("3");
	        TRES.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                TRESActionPerformed(evt);
	            }
	        });
	        jPanel1.add(TRES);

	        QUATRO.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        QUATRO.setText("4");
	        QUATRO.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                QUATROActionPerformed(evt);
	            }
	        });
	        jPanel1.add(QUATRO);

	        LIMPAR.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        LIMPAR.setText("Limpar");
	        LIMPAR.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                LIMPARActionPerformed(evt);
	            }
	        });
	        jPanel1.add(LIMPAR);

	        RAIZ.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        RAIZ.setText("Raiz");
	        RAIZ.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                RAIZActionPerformed(evt);
	            }
	        });
	        jPanel1.add(RAIZ);

	        EXPOENTE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        EXPOENTE.setText("Exp");
	        EXPOENTE.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                EXPOENTEActionPerformed(evt);
	            }
	        });
	        jPanel1.add(EXPOENTE);

	        VIRGULA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        VIRGULA.setText(",");
	        VIRGULA.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                VIRGULAActionPerformed(evt);
	            }
	        });
	        jPanel1.add(VIRGULA);

	        IGUAL.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
	        IGUAL.setText("=");
	        IGUAL.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                IGUALActionPerformed(evt);
	            }
	        });
	        jPanel1.add(IGUAL);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(visor))
	                .addGap(0, 12, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(visor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
	                .addContainerGap())
	        );

	        pack();
	        setLocationRelativeTo(null);
	    }// </editor-fold>                        

	    private void ZEROActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"0");
	    }                                    

	    private void UMActionPerformed(java.awt.event.ActionEvent evt) {                                   
	    	visor.setText(visor.getText()+"1");
	    }                                  

	    private void DOISActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"2");
	    }                                    

	    private void TRESActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"3");
	    }                                    

	    private void QUATROActionPerformed(java.awt.event.ActionEvent evt) {                                       
	    	visor.setText(visor.getText()+"4");
	    }                                      

	    private void CINCOActionPerformed(java.awt.event.ActionEvent evt) {                                      
	    	visor.setText(visor.getText()+"5");
	    }                                     

	    private void SEISActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"6");
	    }                                    

	    private void SETEActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"7");
	    }                                    

	    private void OITOActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"8");
	    }                                    

	    private void NOVEActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	visor.setText(visor.getText()+"9");
	    } 
	    
	    private void VIRGULAActionPerformed(java.awt.event.ActionEvent evt) {                                        
	    	visor.setText(visor.getText()+".");
	    }   
	    
	    private void BACKSPACEActionPerformed(java.awt.event.ActionEvent evt) {                                          
	        visor.setText(visor.getText().substring(0, visor.getText().length()-1));
	    } 

	    private void ADICAOActionPerformed(java.awt.event.ActionEvent evt) {
	    	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 1;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 1;
			     visor.setText("");
			}
	    }                                      

	    private void SUBRITACAOActionPerformed(java.awt.event.ActionEvent evt) {                                           
	       	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 2;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 2;
			     visor.setText("");
			}
	    }                                          

	    private void MULTIPLICACAOActionPerformed(java.awt.event.ActionEvent evt) {                                              
	       	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 3;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 3;
			     visor.setText("");
			}
	    }                                             

	    private void DIVISAOActionPerformed(java.awt.event.ActionEvent evt) {                                        
	       	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 4;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 4;
			     visor.setText("");
			}
	    } 
	    
	    private void EXPOENTEActionPerformed(java.awt.event.ActionEvent evt) {                                         
	    	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 5;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 5;
			     visor.setText("");
			}
	    }                                        

	    private void RAIZActionPerformed(java.awt.event.ActionEvent evt) {                                     
	    	if (operador == 0) {
	    		resultado = Float.parseFloat(visor.getText());
		        operador = 6;
		        visor.setText("");

			} else {
				num = Float.parseFloat(visor.getText());
		         calcular(resultado, num);
		         operador = 6;
			     visor.setText("");
			}
	    }  

                                       

	    private void IGUALActionPerformed(java.awt.event.ActionEvent evt) {
	    	num = Float.parseFloat(visor.getText());
	    	calcular(resultado, num);	    	
	        visor.setText(String.valueOf(resultado));
	        operador = 0;
	    }                                       

	    private void LIMPARActionPerformed(java.awt.event.ActionEvent evt) {                                       
	        visor.setText("");
	        operador = 0;
	    }                                      

	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(CalculadoraDejota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(CalculadoraDejota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(CalculadoraDejota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(CalculadoraDejota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }

	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new CalculadoraDejota().setVisible(true);
	            }
	        });
	    }

               
	    private javax.swing.JButton ADICAO;
	    private javax.swing.JButton BACKSPACE;
	    private javax.swing.JButton CINCO;
	    private javax.swing.JButton DIVISAO;
	    private javax.swing.JButton DOIS;
	    private javax.swing.JButton EXPOENTE;
	    private javax.swing.JButton IGUAL;
	    private javax.swing.JButton LIMPAR;
	    private javax.swing.JButton MULTIPLICACAO;
	    private javax.swing.JButton NOVE;
	    private javax.swing.JButton OITO;
	    private javax.swing.JButton QUATRO;
	    private javax.swing.JButton RAIZ;
	    private javax.swing.JButton SEIS;
	    private javax.swing.JButton SETE;
	    private javax.swing.JButton SUBRITACAO;
	    private javax.swing.JButton TRES;
	    private javax.swing.JButton UM;
	    private javax.swing.JButton VIRGULA;
	    private javax.swing.JTextField visor;
	    private javax.swing.JButton ZERO;
	    private javax.swing.JPanel jPanel1;
               
	}

