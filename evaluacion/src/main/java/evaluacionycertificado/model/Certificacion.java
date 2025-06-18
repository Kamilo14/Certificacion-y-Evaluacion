package evaluacionycertificado.model;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter and setters
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Certificacion")

@Schema(description = "Entidad que representa una certificación obtenida por un usuario")

public class Certificacion {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    private Long id; 

    @Column(nullable = false)
    private String nombre; 
    @Column(nullable = false)
    private String especializacion; 

    @Column(nullable = false)
    private Date fechaEmision; 

    @Column(nullable = false)
    private Date fechaExpiracion; 

       
    @Column(nullable = false)
    private String descripcion;

    
    @Column(name = "curso_id", nullable = false)
    private Long cursoId;  

    
    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "evaluacion_id", nullable = false)
    private Long evaluacionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", insertable = false, updatable = false)
    private Curso curso;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;
}
