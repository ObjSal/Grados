import java.awt.*;
import javax.swing.*;

public class barras extends JPanel
{

	public void paint(Graphics g)
	{
		super.paint(g);
		Font f=new Font("Arial",Font.BOLD,12);

		g.setFont(f);
		g.drawLine(10,228+100+20,335,228+100+20);//la linea de abajo

		//Nombrar Barras
		f = new Font("Arial", Font.BOLD, 12);
		g.setColor(Color.blue);
		int xx=13,yy=0;
		g.drawString("Celsius",xx,40+100+20);
		g.drawString("Fahrenheit",xx+80,40+100+20);
		g.drawString("Kelvin",xx+185,40+100+20);
		g.drawString("Rankine",xx+268,40+100+20);
		g.drawString("°C",xx+10,25+100+20);
		g.drawString("°F",xx+105,25+100+20);
		g.drawString("°K",xx+195,25+100+20);
		g.drawString("°R",xx+283,25+100+20);

		//poner puntos de ebullicion y de congelamiento
		g.setColor(Color.black);
		f = new Font("Arial", Font.PLAIN, 12);
		g.setFont(f);
		//Celsius
		xx=43;
		g.drawString("100°",xx,53+100+20);
		g.drawString("0°",xx,191+100+20);
		g.drawString("212°",xx+90,53+100+20);
		g.drawString("32°",xx+90,191+100+20);
		g.drawString("373°",xx+180,53+100+20);
		g.drawString("273°",xx+180,191+100+20);
		g.drawString("672°",xx+270,53+100+20);
		g.drawString("492°",xx+270,191+100+20);
		//dividores
		xx=0;
		g.drawString("100",xx,245);
		g.drawString("180",xx+90,245);
		g.drawString("100",xx+180,245);
		g.drawString("180",xx+270,245);

		//Ovalos
		g.setColor(Color.black);
		int a=13,b=190+100+20,c=35,d=35;
		g.fillOval(a-2,b-2,c+4,d+4);
		Color brown =new Color(204, 102, 0);
		g.setColor(brown);
		g.fillOval(a,b,c,d);
		a+=90;
		g.setColor(Color.black);
		g.fillOval(a-2,b-2,c+4,d+4);
		g.setColor(Color.red);
		g.fillOval(a,b,c,d);
		a+=90;
		g.setColor(Color.black);
		g.fillOval(a-2,b-2,c+4,d+4);
		g.setColor(Color.pink);
		g.fillOval(a,b,c,d);
		a+=90;
		g.setColor(Color.black);
		g.fillOval(a-2,b-2,c+4,d+4);
		g.setColor(Color.orange);
		g.fillOval(a,b,c,d);


		xx=23;
		//Formar el contorno de las barras
		g.setColor(Color.black);
		a=xx;
		b=169;
		c=17;
		d=190-49+1;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);
		a+=90;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);
		a+=90;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);
		a+=90;
		g.drawRect(a,b,c,d);
		g.drawRect(a-1,b-1,c+2,d+2);

		//Rellenar solo 12 pixeles
		int x=24,y=320;
		g.setColor(brown);
		while (y>=288+20)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		g.setColor(Color.red);
		x+=90;
		y=200+100+20;
		while (y>=288+20)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		g.setColor(Color.pink);
		x+=90;
		y=200+100+20;
		while (y>=288+20)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		g.setColor(Color.orange);
		x+=90;
		y=200+100+20;
		while (y>=288+20)
		{
			g.drawLine(x,y,x+15,y);
			y--;
		}
		//DIBUJAR RALLITAS
		xx=3;

		x=32+xx;y=307;
		g.setColor(Color.black);
		while(y>169)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
		x+=90;
		y=307;
		while(y>169)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
		x+=90;
		y=307;
		while(y>169)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
		x+=90;
		y=307;
		while(y>169)
		{
			g.drawLine(x,y,x+4,y);
			y-=2;
		}
	}
}