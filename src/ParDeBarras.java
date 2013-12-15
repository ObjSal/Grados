import java.awt.*;
import javax.swing.*;

public class ParDeBarras extends JPanel
{
	private byte barras=0;
	private int B1,B2;

	public void dibujar(byte n)
	{
		barras = n;
		repaint();
	}
	public void llenar(final int a,final int b)
	{
		B1=a;
		B2=b;
		repaint();
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		Font f=new Font("Arial",Font.BOLD,12);
		g.setFont(f);

		if(barras==11)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°C <-- °F",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°C - 0°    °F - 32",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,318,75);
			g.drawString("=",257,81);
			g.drawString("100         180",220,90);
			//segunda Ecuacion
			g.drawString("°C =",210,140);
			g.drawLine(245,134,325,134);
			g.drawString("100(°F - 32)",245,131);
			g.drawString("180",269,148);
			//Tercera Ecuacion
			g.drawString("°C =",225,200);
			g.drawLine(260,194,315,194);
			g.drawString("(°F - 32)",260,191);
			g.drawString("1.8",275,208);
			//rectangulo
			g.drawRect(222,177,97,33);
		}
		else if(barras==12)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°F <-- °C",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°F - 32    °C - 0",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,318,75);
			g.drawString("=",257,81);
			g.drawString("180         100",220,90);
			//segunda Ecuacion
			g.drawString("°F - 32 =",210,140);
			g.drawLine(245+25,134,325,134);
			g.drawString("180 °C",245+30,131);
			g.drawString("100",269+15,148);
			//Tercera Ecuacion
			g.drawString("°F = 1.8 °C + 32",225,200);
			//rectangulo
			g.drawRect(222,177,110,33);
		}
		else if(barras==21)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°C <-- °K",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°C - 0°    °K - 273",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,323,75);
			g.drawString("=",257,81);
			g.drawString("100          100",220,90);
			//segunda Ecuacion
			g.drawString("°C = °K - 273°",210,140);
			//rectangulo
			g.drawRect(207,118,97,33);
		}
		else if(barras==22)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°K <-- °C",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°K - 273    °C - 0",210,70);
			g.drawLine(208,75,259,75);g.drawLine(280,75,318,75);
			g.drawString("=",265,81);
			g.drawString("100           100",220,90);
			//segunda Ecuacion
			g.drawString("°K - 273 = °C",210,140);
			//Tercera Ecuacion
			g.drawString("°K = °C + 273",225,200);
			//rectangulo
			g.drawRect(222,177,97,33);
		}
		else if(barras==31)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°C <-- °R",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°C - 0°    °R - 492",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,325,75);
			g.drawString("=",257,81);
			g.drawString("100         180",220,90);
			//segunda Ecuacion
			g.drawString("°C =",210,140);
			g.drawLine(245,134,330,134);
			g.drawString("100(°R - 492)",245,131);
			g.drawString("180",271,148);
			//Tercera Ecuacion
			g.drawString("°C =",225,200);
			g.drawLine(260,194,321,194);
			g.drawString("(°R - 492)",260,191);
			g.drawString("1.8",278,208);
			//rectangulo
			g.drawRect(222,177,105,33);
		}
		else if(barras==32)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°R <-- °C",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°R - 492°    °C - 0",210,70);
			g.drawLine(208,75,264,75);g.drawLine(284,75,328,75);
			g.drawString("=",270,81);
			g.drawString("180           180",227,90);
			//segunda Ecuacion
			g.drawString("°R - 492 =",210,140);
			g.drawLine(278,134,330,134);
			g.drawString("180 °C",284,131);
			g.drawString("100",291,148);
			//Tercera Ecuacion
			g.drawString("°R = 1.8 °C + 492",225,200);
			//rectangulo
			g.drawRect(210,177,135,33);
		}
		else if(barras==41)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°F <-- °K",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°F - 32°    °R - 273",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,328,75);
			g.drawString("=",257,81);
			g.drawString("180           100",220,90);
			//segunda Ecuacion
			g.drawString("°F - 32 =",210,140);
			g.drawLine(269,134,365,134);
			g.drawString("180 (°K - 273)",272,131);
			g.drawString("100",300,148);
			//Tercera Ecuacion
			g.drawString("°F = 1.8(°K - 273) + 32",217,200);
			//rectangulo
			g.drawRect(210,177,165,33);
		}
		else if(barras==42)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°K <-- °F",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°K - 273°    °F - 32",210,70);
			g.drawLine(208,75,264,75);g.drawLine(284,75,328,75);
			g.drawString("=",270,81);
			g.drawString("100           180",227,90);
			//segunda Ecuacion
			g.drawString("°K - 273 =",210,140);
			g.drawLine(278,134,360,134);
			g.drawString("100(°F - 32)",284,131);
			g.drawString("180",306,148);
			//Tercera Ecuacion
			g.drawString("°K =",225,200);
			g.drawLine(260,194,316,194);
			g.drawString("(°F - 32)",260,191);
			g.drawString("1.8",278,208);
			g.drawString("+ 273",321,200);
			//rectangulo
			g.drawRect(222,177,138,33);
		}
		else if(barras==51)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°F <-- °R",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°F - 32°    °R - 492",210,70);
			g.drawLine(208,75,254,75);g.drawLine(270,75,328,75);
			g.drawString("=",257,81);
			g.drawString("180           180",220,90);
			//segunda Ecuacion
			g.drawString("°F = °R - 492 + 32",210,140);
			//Tercera Ecuacion
			g.drawString("°F = °R - 460",225,200);
			//rectangulo
			g.drawRect(210,177,115,33);
		}
		else if(barras==52)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°R <-- °F",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°R - 492°    °F - 32",210,70);
			g.drawLine(208,75,264,75);g.drawLine(284,75,328,75);
			g.drawString("=",270,81);
			g.drawString("180           180",227,90);
			//segunda Ecuacion
			g.drawString("°R - 492 = °F - 32",210,125);
			//Tercera Ecuacion
			g.drawString("°R = °F - 32 + 492",210,160);
			//Cuarta Ecuacion
			g.drawString("°R = °F + 460",225,190);
			//rectangulo
			g.drawRect(220,175,97,18);
		}
		else if(barras==61)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°K <-- °R",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°K - 273°    °R - 492",210,70);
			g.drawLine(208,75,264,75);g.drawLine(284,75,338,75);
			g.drawString("=",270,81);
			g.drawString("100            180",227,90);
			//segunda Ecuacion
			g.drawString("°K - 273 =",210,140);
			g.drawLine(278,134,370,134);
			g.drawString("100(°R - 492)",284,131);
			g.drawString("180",310,148);
			//Tercera Ecuacion
			g.drawString("°K =",225,200);
			g.drawLine(260,194,323,194);
			g.drawString("(°R - 492)",260,191);
			g.drawString("1.8",278,208);
			g.drawString("+ 273",326,200);
			//rectangulo
			g.drawRect(222,177,143,33);
		}
		else if(barras==62)
		{
			f=new Font("Arial",Font.BOLD,30);
			g.setFont(f);
			g.drawString("°R <-- °K",203,30);
			f=new Font("Arial",Font.PLAIN,15);
			g.setFont(f);
			//primera Ecuacion
			g.drawString("°R - 492°    °K - 273",210,70);
			g.drawLine(208,75,264,75);g.drawLine(284,75,338,75);
			g.drawString("=",270,81);
			g.drawString("180            100",227,90);
			//segunda Ecuacion
			g.drawString("°R - 492 =",210,140);
			g.drawLine(278,134,370,134);
			g.drawString("180(°K - 273)",284,131);
			g.drawString("100",310,148);
			//Tercera Ecuacion
			g.drawString("°R = 1.8(°K - 273) + 492",217,200);
			//rectangulo
			g.drawRect(210,177,168,33);
		}
		////////////////////////////////////////////////////////////////Nombrar Barras
		g.setColor(Color.blue);
		byte m=3;
		if(barras==11 || barras==12)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°C",20+m,10);
			g.drawString("°F",110+m,10);
			g.drawString("Celsius",10+m,20);
			g.drawString("Fahrenheit",90+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Celsius
			g.drawString("100°",40+m,35);
			g.drawString("0°",40+m,135);
			g.drawString("100",0,85);
			//Fahrenheit
			g.drawString("212°",130+m,35);
			g.drawString("32°",130+m,135);
			g.drawString("180",90,85);
		}
		else if(barras==21 || barras==22)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°C",20+m,10);
			g.drawString("°K",110+m,10);
			g.drawString("Celsius",10+m,20);
			g.drawString("Kelvin",105+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Celsius
			g.drawString("100°",40+m,35);
			g.drawString("0°",40+m,135);
			g.drawString("100",0,85);
			//Kelvin
			g.drawString("373°",130+m,35);
			g.drawString("273°",130+m,135);
			g.drawString("100",90,85);
		}
		else if(barras==31 || barras==32)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°C",20+m,10);
			g.drawString("°R",110+m,10);
			g.drawString("Celsius",10+m,20);
			g.drawString("Rankine",100+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Celsius
			g.drawString("100°",40+m,35);
			g.drawString("0°",40+m,135);
			g.drawString("100",0,85);
			//Rankine
			g.drawString("672°",130+m,35);
			g.drawString("492°",130+m,135);
			g.drawString("180",90,85);
		}
		else if(barras==41 || barras==42)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°F",20+m,10);
			g.drawString("°K",110+m,10);
			g.drawString("Fahrenheit",0+m,20);
			g.drawString("Kelvin",105+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Fahrenheit
			g.drawString("212°",40+m,35);
			g.drawString("32°",40+m,135);
			g.drawString("180",0,85);
			//Kelvin
			g.drawString("373°",130+m,35);
			g.drawString("273°",130+m,135);
			g.drawString("100",90,85);
		}
		else if(barras==51 || barras==52)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°F",20+m,10);
			g.drawString("°R",110+m,10);
			g.drawString("Fahrenheit",0+m,20);
			g.drawString("Rankine",100+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Fahrenheit
			g.drawString("212°",40+m,35);
			g.drawString("32°",40+m,135);
			g.drawString("180",0,85);
			//Rankine
			g.drawString("672°",130+m,35);
			g.drawString("492°",130+m,135);
			g.drawString("180",90,85);
		}
		else if(barras==61 || barras==62)
		{	//Nombrar Barras
			f = new Font("Arial", Font.BOLD, 12);
			g.setFont(f);
			g.drawString("°K",20+m,10);
			g.drawString("°R",110+m,10);
			g.drawString("Kelvin",15+m,20);
			g.drawString("Rankine",100+m,20);
			//poner puntos de ebullicion y de congelamiento
			g.setColor(Color.black);
			f = new Font("Arial", Font.PLAIN, 12);
			g.setFont(f);
			//Kelvin
			g.drawString("373°",40+m,35);
			g.drawString("273°",40+m,135);
			g.drawString("100",0,85);
			//Rankine
			g.drawString("672°",130+m,35);
			g.drawString("492°",130+m,135);
			g.drawString("180",90,85);
		}

		//Ovalos
		g.setColor(Color.black);
		int a=11+m,b=30+104,c=35,d=35;
		g.fillOval(a-2,b-2,c+4,d+4);
		Color brown =new Color(204, 102, 0);
		g.setColor(brown);
		g.fillOval(a,b,c,d);
		a+=90;
		g.setColor(Color.black);
		g.fillOval(a-2,b-2,c+4,d+4);
		g.setColor(Color.red);
		g.fillOval(a,b,c,d);

		//Formar el contorno de las barras
		g.setColor(Color.black);
		a=20+m;
		b=30;
		c=17;
		d=104;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);
		a+=90;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);

		//Rellenar solo 12 pixeles
		int x=21+m,y=135;
		g.setColor(brown);
		while (y>130)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		g.setColor(Color.red);
		x+=90;
		y=135;
		while (y>130)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		//RELLENAR BARRAS
		if(B1>0)
		{
			x=21+m;y=130;
			g.setColor(brown);
			while (y>B1)
			{
				g.drawLine(x,y,x+15,y);
				y--;
			}
		}
		x=21+m;
		if(B2>0)
		{
			x+=90;y=130;
			g.setColor(Color.red);
			while (y>B2)
			{
				g.drawLine(x,y,x+15,y);
				y--;
			}
		}
		//dibujar rallitas
		x=32+m;y=130;
		g.setColor(Color.black);
		while(y>30)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
		x+=90;
		y=130;
		while(y>30)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
	}
}