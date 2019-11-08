using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Xml;

namespace Tarea4
{
    class XmlToSvgParser
    {
        static void Main(string[] args)
        {
            int i = 0;
            int marginH = 200;
            int marginW = 20;

            // PARSING THE XML INTO OBJECTS
            XmlDocument doc = new XmlDocument();
            doc.Load(@".\tarea4.xml");

            XmlNodeList nodosRuta = doc.DocumentElement.SelectNodes("ruta");

            foreach(XmlNode ruta in nodosRuta)
            {
                i++;
                Ruta r = new Ruta();
                Punto o = new Punto();

                o.nombre = ruta.SelectSingleNode("inicio").SelectSingleNode("lugar").InnerText;
                o.x = marginW;
                o.y = marginH;
                float reg = float.Parse(ruta.SelectSingleNode("inicio").SelectSingleNode("coordenadas").Attributes["altitud"].Value);
                r.nombre = ruta.SelectSingleNode("nombre").InnerText;
                r.origen = o;

                float totalX = marginW;
                string text = "";

                XmlNodeList hitos = ruta.SelectNodes("hitos/hito");
                foreach(XmlNode hito in hitos)
                {
                    Punto p = new Punto();
                    p.nombre = hito.SelectSingleNode("nombreHito").InnerText;
                    
                    p.x = totalX + float.Parse(hito.Attributes["distancia"].Value)*10;
                    p.y = o.y - (float.Parse(hito.SelectSingleNode("coordenadas").Attributes["altitud"].Value) - reg);

                    totalX = p.x;
                    r.puntos.Add(p);   
                }
                // DIBUJA LA LÍNEA REPRESENTANDO LA RUTA
                text = "<?xml version = \"1.0\" encoding = \"utf-8\"?>\n";
                text += "<svg width=\"100vw\" height=\"100vh\" style=\"overflow:visible\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n";
                text += "<polyline points=\"" + r.getPuntos() + "\" style=\"fill:none;stroke:red;stroke-width:3\"/>\n";
                // AÑADE LOS NOMBRES
                text+= "<text transform=\"translate(" + r.origen.x + "," + (r.origen.y + 20) + ") rotate(90) translate(" + -r.origen.x + "," + (-r.origen.y - 20) + ")\" x=\"" + r.origen.x + "\" y=\"" + (r.origen.y + 20) + "\" fill=\"black\">" + r.origen.nombre + "</text>\n";
                r.puntos.ForEach(p => text += "<text transform=\"translate(" + p.x +","+ (r.origen.y+20) + ") rotate(90) translate(" + -p.x + "," + (-r.origen.y - 20) + ")\" x=\"" + p.x + "\" y=\"" + (r.origen.y+20) + "\" fill=\"black\">" + p.nombre + "</text>\n");
                // ESCRIBE EL ARCHIVO
                text += "</svg>";
                System.IO.File.WriteAllText(@".\tarea4." + i + ".svg", text);

            }
        }
    }

    class Ruta
    {
        public string nombre;
        public Punto origen;
        public List<Punto> puntos;

        public Ruta()
        {
            puntos = new List<Punto>();
        }
        public string getPuntos()
        {
            string aux = origen.getPunto();
            puntos.ForEach(p => aux += " " + p.getPunto());
            aux += " " + puntos.Last().x + "," + origen.y;
            aux += " " + origen.getPunto();
            return aux;
        }
    }
    class Punto
    {
        public string nombre;
        public float x;
        public float y;
        public string getPunto()
        {
            return x + "," + y;
        }
    }
}
