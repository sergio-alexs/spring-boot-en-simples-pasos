package com.springsimplespasos.universidad.universidadbackend.controlador.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springsimplespasos.universidad.universidadbackend.datos.DatosDummy;
import com.springsimplespasos.universidad.universidadbackend.modelo.dto.AlumnoDTO;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Alumno;
import com.springsimplespasos.universidad.universidadbackend.modelo.entidades.Direccion;
import com.springsimplespasos.universidad.universidadbackend.modelo.mapper.mapstruct.AlumnoMapper;
import com.springsimplespasos.universidad.universidadbackend.servicios.contratos.AlumnoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AlumnoDtoController.class)
class AlumnoDtoControllerTest {

    @Autowired
    private MockMvc mockMvc; //Objeto para simular las peticiones HTTP
    @MockBean
    private AlumnoDAO alumnoDAO; //Transformo como Mock las clases inyectadas en mi controlador
    @MockBean
    private AlumnoMapper mapper; //Transformo como Mock las clases inyectadas en mi controlador
    private ObjectMapper objectMapper; //Objeto que me pertime pasar de JSON a Objeto


    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void obtenerAlumnoPorId() throws Exception {
        //GIVEN
        AlumnoDTO dto = new AlumnoDTO(
                null,
                DatosDummy.alumno01().getNombre(),
                DatosDummy.alumno01().getApellido(),
                DatosDummy.alumno01().getDni(),
                DatosDummy.alumno01().getDireccion()
        );

        /*
            Como tengo mi servicio y mi mapper como MockBean
            debo de simular su correspondiente uso
         */
        when(this.alumnoDAO.findById(anyInt()))
                .thenReturn(Optional.of(DatosDummy.alumno01()));

        when(this.mapper.mapAlumno(any(Alumno.class)))
                .thenReturn(dto);

        //WHEN
        mockMvc.perform(
              get("/alumnos/{id}", anyInt()) //Cada verbo HTTP posee su propio metodo
                      .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print()) //Imprimo en consola tanto Request y Response simulados
                //THEN
                .andExpect(status().isOk()) //Valido que el status code sea 200 con metodo status
                //Valido datos del Body recorriendo el JSON a traves del metodo jsonPath, simbolo $ es la raiz del JSON
                .andExpect(jsonPath("$.data.dni").value(DatosDummy.alumno01().getDni()))
                .andExpect(jsonPath("$.success").value(Boolean.TRUE));
    }

    @Test
    void altaAlumno() throws Exception {
        //GIVEN
        AlumnoDTO dto = new AlumnoDTO(
                null,
                "Alumno Test",
                "Apellido Test",
                "55555555",
                new Direccion()
        );

        //WHEN
        mockMvc.perform(
                post("/alumnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(dto))
        ).andDo(print())
                //THEN
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.succes").value("true"));
    }
}