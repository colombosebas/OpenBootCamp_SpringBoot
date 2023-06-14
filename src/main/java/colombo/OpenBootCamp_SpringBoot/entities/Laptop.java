package colombo.OpenBootCamp_SpringBoot.entities;

import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Laptops")
public class Laptop {
//        atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave Long autoincremental")
    private Long id;
    private String marca;
    private String modelo;
    private Integer portUSB;
    private Double price;
    private LocalDate releaseDate;
    private boolean windows;

//    constructores

    public Laptop() {
    }

    public Laptop(Long id, String marca, String modelo, Integer portUSB, Double price, LocalDate releaseDate, boolean windows) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.portUSB = portUSB;
        this.price = price;
        this.releaseDate = releaseDate;
        this.windows = windows;
    }
    //    geter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getmarca() {
        return marca;
    }

    public void setmarca(String marca) {
        this.marca = marca;
    }

    public String getmodelo() {
        return modelo;
    }

    public void setmodelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getportUSB() {
        return portUSB;
    }

    public void setportUSB(Integer portUSB) {
        this.portUSB = portUSB;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean iswindows() {
        return windows;
    }

    public void setwindows(boolean windows) {
        this.windows = windows;
    }


//    tostring

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", portUSB=" + portUSB +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", windows=" + windows +
                '}';
    }
}
