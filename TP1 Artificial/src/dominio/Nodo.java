package dominio;

public class Nodo { 
	private int x;
	private int y;
	private int piso;
	private String descripcion;
	
	public Nodo() {		
	
	}
	
	public Nodo(int x, int y, int piso, String descripcion){
		this.setX(x);
		this.setY(y);
		this.setPiso(piso);
		this.setDescripcion(descripcion);
	}
	
	public Nodo clone(){
		Nodo nuevoNodo = new Nodo();
		nuevoNodo.setX(this.getX());
		nuevoNodo.setY(this.getY());
		nuevoNodo.setPiso(this.getPiso());
		nuevoNodo.setDescripcion(this.getDescripcion());
		return nuevoNodo;
	}

	public boolean equal(Nodo nodo){
		
		return (this.getX()==nodo.getX()&&this.getY()==nodo.getY()&&this.getPiso()==nodo.getPiso());		
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getPiso() {
		return piso;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;	
	}
	public String getDescripcion(){
		return descripcion;
	}

}