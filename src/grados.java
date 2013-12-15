import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;

public class grados extends JFrame
{
	private JPanel panel;
	private JButton botones[],botonCF,botonCK,botonCR,botonFK,botonFR,botonKR;
	private JRadioButton opcion1_CF,opcion2_CF,opcion1_CK,opcion2_CK,opcion1_CR,opcion2_CR,opcion1_FK,opcion2_FK,opcion1_FR,opcion2_FR,opcion1_KR,opcion2_KR;
	private ButtonGroup grupoOpciones;
	private JDesktopPane elEscritorio;
	private JInternalFrame menu,CF;
	private ParDeBarras ParBarras;
	private barras panelBarras;//llamar a barras.class
	private Container contenedor;
	private GridBagLayout esquema;
	private GridBagConstraints restricciones;

	//configurar la GUI
	public grados()
	{
		super("Conversion de Grados");
		JMenuBar barra = new JMenuBar();
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem cerrarMDI = new JMenuItem("Cerrar");
		menuArchivo.add(cerrarMDI);
		barra.add(menuArchivo);

		JMenu menuAyuda = new JMenu("Ayuda");
		JMenuItem AcercaDe = new JMenuItem("Acerca De...");
		menuAyuda.add(AcercaDe);

		barra.add(menuAyuda);
		setJMenuBar(barra);

		//establecer escritorio
		elEscritorio = new JDesktopPane();
		//Container contenedor = getContentPane();
		getContentPane().add(elEscritorio);

		Comandos manejador = new Comandos();

		JInternalFrame menu = new JInternalFrame("Menu",
			true, //resizable
          	false, //closable
          	true, //maximizable
          	true);//iconifiable
		Container contenedor = menu.getContentPane();

		//PANELES
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,4,0,0));
		botones=new JButton[28];
		for(int k=0;k<28;k++)
		{
			if(k==0)
				botones[k] = new JButton("CELSIUS");//botones[k].setBackground(new Color(0, 102, 255));}
			else if(k==1)
				botones[k] = new JButton("FAHRENHEIT");
			else if(k==2)
				botones[k] = new JButton("KELVIN");
			else if(k==3)
				botones[k] = new JButton("RANKINE");
			else if(k>3)
			{
				if(k==4 || k==5 || k==8 || k==10 || k==12 || k==15 || k==17 || k==18 || k==21 || k==23 || k==26 || k==27)
				{
					botones[k] = new JButton("*");
					botones[k].setFont(new Font("Times New Roman",0,50));
					botones[k].addActionListener(manejador);
				}
				else
					{
						botones[k] = new JButton(" ");
						botones[k].setFont(new Font("Dialog",0, 1));
						botones[k].setEnabled(false);
					}
			}
			panel.add(botones[k]);
		}

		contenedor.add(panel,BorderLayout.EAST);

		panelBarras = new barras();
		contenedor.add(panelBarras,BorderLayout.CENTER);

		JLabel E;
		E = new JLabel("Salvador Guerrero Varela",SwingConstants.LEFT);
		getContentPane().add(E,BorderLayout.SOUTH);

		//menu.pack();

		menu.setSize(730,500);
		elEscritorio.add(menu);
		try//maximizar menu
            {
                  menu.setSelected ( true ) ;
                  menu.setMaximum(true);
            }
            catch ( java.beans.PropertyVetoException e )
            {}

		menu.setVisible(true);
		//menu.setMaximum(true);

		//establecer componente de escucha para elemento de menu Archivo
		cerrarMDI.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent evento)
				{
					System.exit(0);
				}
			}
		);
		AcercaDe.addActionListener
		(
			new ActionListener()
			{
				public void actionPerformed(ActionEvent evento)
				{
					JOptionPane.showMessageDialog(null,"ELABORACIÓN Y DISEÑO:\n"+"Tec. Salvador Guerrero Varela\nIng. Javier Mendoza Navarrete\nDomicilio: Ave. Coahuila A 25 y 26 No.2503\nColonia: Federal\nCodigo Postal: 83489\nTelefono: 01-(653)-53-6-71-39\nSan Luis Rio Colorado, Sonora","Acerca De...",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		);

		setSize(800,600);
		setVisible(true);
	}//Escritorio

	private class Comandos implements ActionListener//manejador de JTextFiel's y JBotton
		{
			public void actionPerformed(ActionEvent evento)
			{
				if(evento.getSource()==botones[4] || evento.getSource()==botones[5])//celsius fahrenheit
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonCF = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonCF.addActionListener(com);
					c.add(botonCF,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_CF = new JRadioButton("Fahrenheit a Celsius",true);
					opcion2_CF=new JRadioButton("Celsius a Fahrenheit",false);
					opcion1_CF.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Fahrenheit a Celsius");
					opcion2_CF.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Celsius a Fahrenheit");
					c.add(opcion1_CF,BorderLayout.NORTH);
					c.add(opcion2_CF,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_CF);
					grupoOpciones.add(opcion2_CF);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botones[8] || evento.getSource()==botones[10])//celsius kelvin
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonCK = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonCK.addActionListener(com);
					c.add(botonCK,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_CK = new JRadioButton("Kelvin a Celsius",true);
					opcion2_CK=new JRadioButton("Celsius a Kelvin",false);
					opcion1_CK.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Kelvin a Celsius");
					opcion2_CK.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Celsius a Kelvin");
					c.add(opcion1_CK,BorderLayout.NORTH);
					c.add(opcion2_CK,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_CK);
					grupoOpciones.add(opcion2_CK);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botones[12] || evento.getSource()==botones[15])//celsius Rankine
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonCR = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonCR.addActionListener(com);
					c.add(botonCR,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_CR = new JRadioButton("Rankine a Celsius",true);
					opcion2_CR=new JRadioButton("Celsius a Rankine",false);
					opcion1_CR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Rankine a Celsius");
					opcion2_CR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Celsius a Rankine");
					c.add(opcion1_CR,BorderLayout.NORTH);
					c.add(opcion2_CR,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_CR);
					grupoOpciones.add(opcion2_CR);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botones[17] || evento.getSource()==botones[18])//Fahrenheit Kelvin
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonFK = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonFK.addActionListener(com);
					c.add(botonFK,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_FK = new JRadioButton("Kelvin a Fahrenheit",true);
					opcion2_FK=new JRadioButton("Fahrenheit a Kelvin",false);
					opcion1_FK.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Kelvin a Fahrenheit");
					opcion2_FK.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Fahrenheit a Kelvin");
					c.add(opcion1_FK,BorderLayout.NORTH);
					c.add(opcion2_FK,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_FK);
					grupoOpciones.add(opcion2_FK);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botones[21] || evento.getSource()==botones[23])//Fahrenheit Rankine
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonFR = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonFR.addActionListener(com);
					c.add(botonFR,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_FR = new JRadioButton("Rankine a Fahrenheit",true);
					opcion2_FR=new JRadioButton("Fahrenheit a Rankine",false);
					opcion1_FR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Rankine a Fahrenheit");
					opcion2_FR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Fahrenheit a Rankine");
					c.add(opcion1_FR,BorderLayout.NORTH);
					c.add(opcion2_FR,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_FR);
					grupoOpciones.add(opcion2_FR);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botones[26] || evento.getSource()==botones[27])//Kelvin Rankine
				{
					JInternalFrame CF = new JInternalFrame(
						"Convertir de:",
						true, //resizable
       					true, //closable
       					false, //maximizable
       					true);//iconifiable
       				CF.setClosable(true);
					Container c = CF.getContentPane();
					//boton
					botonKR = new JButton("Aceptar");
					Comandos com = new Comandos();
					botonKR.addActionListener(com);
					c.add(botonKR,BorderLayout.SOUTH);
					//opcion1 opcion2
					opcion1_KR = new JRadioButton("Rankine a Kelvin",true);
					opcion2_KR=new JRadioButton("Kelvin a Rankine",false);
					opcion1_KR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Rankine a Kelvin");
					opcion2_KR.setToolTipText("Seleccionar Esta Opcion Si Quieres Convertir de Kelvin a Rankine");
					c.add(opcion1_KR,BorderLayout.NORTH);
					c.add(opcion2_KR,BorderLayout.CENTER);
					grupoOpciones=new ButtonGroup();
					grupoOpciones.add(opcion1_KR);
					grupoOpciones.add(opcion2_KR);
					CF.pack();
					CF.setBounds((elEscritorio.getWidth()-CF.getWidth())/2,(elEscritorio.getHeight()-CF.getHeight())/2,300,300);
					CF.pack();
					elEscritorio.add(CF);
					CF.setVisible(true);
				}
				else if(evento.getSource()==botonCF)
				{
					if(opcion1_CF.isSelected())
					{
						CelsiusF CelF = new CelsiusF();
					}
					else if(opcion2_CF.isSelected())
					{
						FahrenheitC FahC = new FahrenheitC();
					}
				}
				else if(evento.getSource()==botonCK)
				{
					if(opcion1_CK.isSelected())
					{
						CelsiusK CelK = new CelsiusK();
					}
					else if(opcion2_CK.isSelected())
					{
						KelvinC KelC = new KelvinC();
					}
				}
				else if(evento.getSource()==botonCR)
				{
					if(opcion1_CR.isSelected())
					{
						CelsiusR CelR = new CelsiusR();
					}
					else if(opcion2_CR.isSelected())
					{
						RankineC RanC = new RankineC();
					}
				}
				else if(evento.getSource()==botonFK)
				{
					if(opcion1_FK.isSelected())
					{
						FahrenheitK FahK = new FahrenheitK();
					}
					else if(opcion2_FK.isSelected())
					{
						KelvinF KelF = new KelvinF();
					}
				}
				else if(evento.getSource()==botonFR)
				{
					if(opcion1_FR.isSelected())
					{
						FahrenheitR FahR = new FahrenheitR();
					}
					else if(opcion2_FR.isSelected())
					{
						RankineF RanF = new RankineF();
					}
				}
				else if(evento.getSource()==botonKR)
				{
					if(opcion1_KR.isSelected())
					{
						KelvinR KelR = new KelvinR();
					}
					else if(opcion2_KR.isSelected())
					{
						RankineK RanK = new RankineK();
					}
				}
			}
		}
		public class CelsiusF extends JInternalFrame
		{
			public CelsiusF()
			{
				JInternalFrame CelsiusF = new JInternalFrame("Fahrenheit a Celsius",true,true,true,true);

				contenedor = CelsiusF.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=11;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °F: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°C");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(in-32)/1.8;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°C");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n1=Integer.parseInt(dosDigitos.format(T));//Celsius
									int n2=Integer.parseInt(dosDigitos.format(in));//fahrenheit
									if(n2>212)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n1=130-n1;
										ParBarras.llenar(n1,n1);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(CelsiusF);
				CelsiusF.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				CelsiusF.setVisible(true);
			}
		}//CelsiusF
		public class FahrenheitC extends JInternalFrame
		{
			public FahrenheitC()
			{
				JInternalFrame FahrenheitC = new JInternalFrame("Celsius a Fahrenheit",true,true,true,true);

				contenedor = FahrenheitC.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=12;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °C: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°F");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(1.8*in)+32;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°F");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Celsius
									if(n2>100)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n2=130-n2;
										ParBarras.llenar(n2,n2);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(FahrenheitC);
				FahrenheitC.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				FahrenheitC.setVisible(true);
			}
		}//FahrenheitC
		public class CelsiusK extends JInternalFrame
		{
			public CelsiusK()
			{
				JInternalFrame  CelsiusK = new JInternalFrame("Kelvin a Celsius",true,true,true,true);

				contenedor =  CelsiusK.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=21;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °K: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°C");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=in-273;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°C");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n1=Integer.parseInt(dosDigitos.format(T));//Celsius
									int n2=Integer.parseInt(dosDigitos.format(in));//Kelvin
									if(n2>373)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n1=130-n1;
										ParBarras.llenar(n1,n1);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add( CelsiusK);
				CelsiusK.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				CelsiusK.setVisible(true);
			}
		}//CelsiusK
		public class KelvinC extends JInternalFrame
		{
			public KelvinC()
			{
				JInternalFrame  KelvinC = new JInternalFrame("Celsius a Kelvin",true,true,true,true);

				contenedor =  KelvinC.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=22;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °C: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°K");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=in+273;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°K");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Celsius
									if(n2>100)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n2=130-n2;
										ParBarras.llenar(n2,n2);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(KelvinC);
				KelvinC.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				KelvinC.setVisible(true);
			}
		}//KelvinC
		public class CelsiusR extends JInternalFrame
		{
			public CelsiusR()
			{
				JInternalFrame  CelsiusR = new JInternalFrame("Rankine a Celsius",true,true,true,true);

				contenedor =  CelsiusR.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=31;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °R: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°C");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(in-492)/1.8;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°C");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n1=Integer.parseInt(dosDigitos.format(T));//Celsius
									int n2=Integer.parseInt(dosDigitos.format(in));//Kelvin
									if(n2>672)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n1=130-n1;
										ParBarras.llenar(n1,n1);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add( CelsiusR);
				CelsiusR.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				CelsiusR.setVisible(true);
			}
		}//CelsiusR
		public class RankineC extends JInternalFrame
		{
			public RankineC()
			{
				JInternalFrame  RankineC = new JInternalFrame("Celsius a Rankine",true,true,true,true);

				contenedor =  RankineC.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=32;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °C: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°R");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(1.8*in)+492;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°R");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Celsius
									if(n2>100)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n2=130-n2;
										ParBarras.llenar(n2,n2);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(RankineC);
				RankineC.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				RankineC.setVisible(true);
			}
		}//RankineC
		public class FahrenheitK extends JInternalFrame
		{
			public FahrenheitK()
			{
				JInternalFrame  FahrenheitK = new JInternalFrame("Kelvin a Fahrenheit",true,true,true,true);

				contenedor =  FahrenheitK.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=41;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °K: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°F");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(1.8*(in-273))+32;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°F");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Kelvin
									if(n2>373)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n2=(373-n2)+30;
										ParBarras.llenar(n2,n2);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(FahrenheitK);
				FahrenheitK.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				FahrenheitK.setVisible(true);
			}
		}//FahrenheitK
		public class KelvinF extends JInternalFrame
		{
			public KelvinF()
			{
				JInternalFrame  KelvinF = new JInternalFrame("Fahrenheit a Kelvin",true,true,true,true);

				contenedor =  KelvinF.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=42;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °F: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°K");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=((in-32)/1.8)+273;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°K");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n1=Integer.parseInt(dosDigitos.format(T));//Kelvin
									int n2=Integer.parseInt(dosDigitos.format(in));//Fahrenheit
									if(n2>212)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n1=(373-n1)+30;
										ParBarras.llenar(n1,n1);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(KelvinF);
				KelvinF.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				KelvinF.setVisible(true);
			}
		}//KelvinF
		public class FahrenheitR extends JInternalFrame
		{
			public FahrenheitR()
			{
				JInternalFrame  FahrenheitR = new JInternalFrame("Rankine a Fahrenheit",true,true,true,true);

				contenedor =  FahrenheitR.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=51;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °R: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°F");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=in-460;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°F");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Rankine
									double cel=(in-492)/1.8;
									int Ll=Integer.parseInt(dosDigitos.format(cel));//celsius para llenar barras
									if(n2>672)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										Ll=130-Ll;
										ParBarras.llenar(Ll,Ll);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(FahrenheitR);
				FahrenheitR.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				FahrenheitR.setVisible(true);
			}
		}//FahrenheitR
		public class RankineF extends JInternalFrame
		{
			public RankineF()
			{
				JInternalFrame  RankineF = new JInternalFrame("Fahrenheit a Rankine",true,true,true,true);

				contenedor =  RankineF.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=52;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °F: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°R");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=in+460;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°R");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//Fahrenheit
									double cel=(in-32)/1.8;
									int Ll=Integer.parseInt(dosDigitos.format(cel));//Celsius para llenar barras
									if(n2>212)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										Ll=130-Ll;
										ParBarras.llenar(Ll,Ll);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(RankineF);
				RankineF.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				RankineF.setVisible(true);
			}
		}//RankineF
		public class KelvinR extends JInternalFrame
		{
			public KelvinR()
			{
				JInternalFrame  KelvinR = new JInternalFrame("Rankine a Kelvin",true,true,true,true);

				contenedor =  KelvinR.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=61;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °R: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°K");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=((in-492)/1.8)+273;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°K");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n1=Integer.parseInt(dosDigitos.format(T));
									int n2=Integer.parseInt(dosDigitos.format(in));
									if(n2>672)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n1=(373-n1)+30;
										ParBarras.llenar(n1,n1);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(KelvinR);
				KelvinR.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				KelvinR.setVisible(true);
			}
		}//KelvinR
		public class RankineK extends JInternalFrame
		{
			public RankineK()
			{
				JInternalFrame  RankineK = new JInternalFrame("Kelvin a Rankine",true,true,true,true);

				contenedor =  RankineK.getContentPane();
				esquema = new GridBagLayout();
				contenedor.setLayout(esquema);
				restricciones = new GridBagConstraints();

				ParBarras = new ParDeBarras();
				restricciones.weightx=1000;//puede hacerse mas ancho
				restricciones.weighty=1;//puede hacerse mas largo

				restricciones.fill = GridBagConstraints.BOTH;
				byte n=62;
				ParBarras.dibujar(n);
				agregarComponente(ParBarras,0,0,4,1);

				restricciones.weightx=0;
				restricciones.weighty=0;

				JLabel label = new JLabel("Escribir °K: ");
				agregarComponente(label,1,0,1,1);

				final JTextField caja = new JTextField("",10);
				agregarComponente(caja,1,1,1,1);

				JButton boto = new JButton("Aceptar");
				boto.setToolTipText("Convertir");
				agregarComponente(boto,2,0,2,1);

				JLabel espacio1 = new JLabel(" ");
				agregarComponente(espacio1,3,0,3,1);

				JLabel espacio2 = new JLabel("         =        ");
				agregarComponente(espacio2,1,2,1,2);

				final JLabel total = new JLabel("°R");
				total.setFont( new Font("Arial",Font.BOLD,20));
				agregarComponente(total,1,3,1,2);

				//agregar escucha en boto
				boto.addActionListener(
					new ActionListener()
					{
						public void actionPerformed(ActionEvent evento)
						{
							String cadena=caja.getText();
							if(cadena.length()==0)
							{
								JOptionPane.showMessageDialog(null,"Escribir Cantidad a Convertir");
								caja.setText("");
								caja.grabFocus();
							}
							else
							{
								int k=0;
								for(int i=0;i<cadena.length();i++)
								{
									char car=cadena.charAt(i);
									if((car>='0' && car<='9')|| car=='-' || car=='.')
										k++;
								}
								if(k==cadena.length())
								{
									double in=Double.parseDouble(cadena);
									DecimalFormat dosDigitos=new DecimalFormat("0.00");
									double T=(1.8*(in-273))+492;
									String TT=String.valueOf(dosDigitos.format(T));
									total.setText(TT+"°R");
									caja.grabFocus();
									dosDigitos=new DecimalFormat("0");
									int n2=Integer.parseInt(dosDigitos.format(in));//kelvin
									if(n2>373)
									{
										ParBarras.llenar(30,30);
									}
									else
									{
										n2=(373-n2)+30;
										ParBarras.llenar(n2,n2);
									}
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Solo Numeros");
									caja.setText("");
									caja.grabFocus();
								}
							}
						}
					}
				);

				elEscritorio.add(RankineK);
				RankineK.setBounds((elEscritorio.getWidth()-400)/2,(elEscritorio.getHeight()-320)/2,400,320);
				RankineK.setVisible(true);
			}
		}//RankineK
	private void agregarComponente(Component componente,int fila,int columna,int anchura,int altura)
	{
		restricciones.gridx=columna;
		restricciones.gridy=fila;
		restricciones.gridwidth=anchura;
		restricciones.gridheight=altura;
		esquema.setConstraints(componente,restricciones);
		contenedor.add(componente);
	}
	public static void main(String[]args)
	{
		grados aplicacion = new grados();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//main
}//JFrame