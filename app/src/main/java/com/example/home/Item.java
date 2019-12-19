package com.example.home;

public class Item {
        public String photo;
        public String precio;
        public String property_descrytion​;
        public String zone;
        public String estado;
        public int id;

    public Item(String photo, String property_descrytion, String precio, String zone, String estado) {
        this.photo = photo;
        this.property_descrytion​ = property_descrytion;
        this.precio = precio;
        this.zone = zone;
        this.estado = estado;
    }

    public Item(int i) {
    }
    public void setPhoto​(String photo){
            this.photo = photo;
        }
        public void setProperty_descrytion​(String property_descrytion​​){
            this.property_descrytion​ = property_descrytion​;
        }
        public void setPrecio​(String precio){
            this.precio = precio;
        }
        public void setZone​(String zone){
        this.zone = zone;
    }
        public void setEstado(String estado){
        this.estado = estado;
    }
        public void setId​(int id​){
            this.id = id;
        }


        public int getId​(){
            return this.id;
        }
        public String getPhoto(){
            return  this.photo;
        }
        public String getProperty_descrytion​​(){
            return this.property_descrytion​;
        }
        public String getPrecio(){
            return this.precio;
        }

        public String getZone(){
        return this.zone;
    }
        public String getEstado(){
        return this.estado;
    }
}
