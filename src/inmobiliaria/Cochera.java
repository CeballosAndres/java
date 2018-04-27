package inmobiliaria;

import javax.swing.JOptionPane;

public class Cochera {
    private int capacidad;
    private int techada;
    
    public Cochera(){
        this.capacidad = 0;
        this.techada = JOptionPane.NO_OPTION; //no tiene cochera
    }
    
    public void registrarCochera(){
        techada = JOptionPane.showConfirmDialog(null,"¿La cochera esta techada?","Elija una opción", JOptionPane.YES_NO_OPTION);
        capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidad de automoviles: "));
    }
    
    public String verCochera(){
        return "Si\n     Capacidad: "+this.capacidad+"\n     Techada: "+tieneTecho();
    }
    
    public String tieneTecho(){
        if (this.techada == JOptionPane.YES_OPTION) {
            return "Si";
        }
        return "No";
    }
    
}
