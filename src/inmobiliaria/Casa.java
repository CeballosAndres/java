package inmobiliaria;
import javax.swing.JOptionPane;

public class Casa {
    private Recamara recamaras[] = new Recamara[10];
    private Cochera coch = new Cochera();

    private int noHabitaciones;
    private float precio;
    private String direccion;
    private float mtsConstruidos;
    private boolean estado;
    private int cochera;
    
    //Constructor
    public Casa(){
        this.noHabitaciones = 0;
        this.precio = 0.0f;
        this.direccion = null;
        this.mtsConstruidos = 0.0f;
        this.estado = false;
        this.cochera = JOptionPane.NO_OPTION;
        for (int i = 0; i < recamaras.length; i++) {
            this.recamaras[i] = null;
        }
    }
    //Constructor alternativo
    public Casa(int noHabitaciones, float precio, String direccion, float mtsConstruidos){
        this.noHabitaciones = noHabitaciones;
        this.precio = precio;
        this.direccion = direccion;
        this.mtsConstruidos = mtsConstruidos;
    }
    public boolean getEstado(){
        return this.estado;
    }
    
    public int getNoHabitaciones(){
        return this.noHabitaciones;
    }
   
    
    public void rentar(){
        this.estado = true;
    }
    
    public void desocupar(){
        this.estado = false;
    }
    public void actualizarPrecio(){
        JOptionPane.showMessageDialog(null, "El precio actual es $"+this.precio);
        this.precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el nuevo precio."));
        JOptionPane.showMessageDialog(null, "Precio actualizado a $"+this.precio);
    }
    public void registrar(){
        this.direccion = JOptionPane.showInputDialog("Dirección: ");
        this.precio = Float.parseFloat(JOptionPane.showInputDialog("Precio: "));
        this.mtsConstruidos = Float.parseFloat(JOptionPane.showInputDialog("Metros cosntruidos: "));
        this.noHabitaciones = Integer.parseInt(JOptionPane.showInputDialog("No. de habitaciones: "));
        registrarHabitaciones();
        this.cochera = JOptionPane.showConfirmDialog(null, "¿Tiene cochera?", "Elija una opción", JOptionPane.YES_NO_OPTION);
        registrarCochera();
        this.estado = false;
        verDatos();
         
    }
    
    public void registrarCochera(){
        if (this.cochera == JOptionPane.YES_OPTION) {
            coch.registrarCochera();
        }
    }
    
    public void registrarHabitaciones(){
        if (this.noHabitaciones > 0) {
            for (int i = 0; i < this.noHabitaciones; i++) {
                JOptionPane.showMessageDialog(null, "Datos habitacion "+(i+1));
                Recamara rec = new Recamara();
                rec.registrarRecamara();
                recamaras[i] = rec;
                
            }
        }
    }
    public void verDatos(){
        JOptionPane.showMessageDialog(null, 
                "- Dirección: "+this.direccion+
                "\n- Metros construidos: "+this.mtsConstruidos+
                "\n- Precio de renta: "+this.precio+
                "\n- Estado: "+estatus()+
                "\n- Número de habitaciones: "+this.noHabitaciones+
                verHabitaciones()+
                "\n- Cochera: "+verCochera());        
    }
    public String verCochera(){
        if (this.cochera == JOptionPane.YES_OPTION) {
            return coch.verCochera();
        }
        return "No";
    }
    
    public String verHabitaciones(){
        String cadena ="";
        for (int i = 0; i < this.noHabitaciones; i++) {
            cadena += "\n  - Recamara "+(i+1)+": "+this.recamaras[i].verRecamara();
        }
        return cadena;
    }
    
    public String estatus(){
        if (this.estado) {
            return "Ocupado";
        } else {
            return "Disponible";
        }
    }
    
    
    public void eliminar(){
        //Aqui va el codigo eliminar
    }
}
