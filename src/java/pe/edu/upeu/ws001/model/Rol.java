package pe.edu.upeu.ws001.model;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * @author CAMPOS
 */

@AllArgsConstructor
@NoArgsConstructor
@lombok.Setter
@lombok.Getter
public class Rol {
    private int idrol;
    private String nombre;
}
