package inmobiliaria;

import javax.swing.JOptionPane;

public class Recamara {
    private float mts2;
    private int noVentanas;
    
    public Recamara(){
        this.mts2 = 0.0f;
        this.noVentanas = 0;
    }
    
    public void registrarRecamara(){
        this.mts2 = Float.parseFloat(JOptionPane.showInputDialog("Metros cuadrados de la recamara"));
        this.noVentanas = Integer.parseInt(JOptionPane.showInputDialog("Número de Ventanas"));
    }
    
    public String verRecamara(){
        return ("\n     Metros habitacion: "+this.mts2+"\n     No. de ventanas: "+this.noVentanas);
    }
    
}
