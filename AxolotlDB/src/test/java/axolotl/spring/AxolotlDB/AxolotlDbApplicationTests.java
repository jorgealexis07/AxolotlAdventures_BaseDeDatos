package axolotl.spring.AxolotlDB;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import axolotl.spring.AxolotlDB.controller.model.Actividades;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class AxolotlDbApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Prueba el método POST para crear una actividad")
	public void pruebaPOST() throws Exception {
		Actividades p = new Actividades();
		p.setNom_actv("Viajecito");
		p.setDescrip_actv("Viajecito bonito");
		p.setImg_actv("imagen1.jpg");
		p.setPrecio_actv(74);
		
		this.mockMvc.perform( post("/api/actividades/")
				.contentType(MediaType.APPLICATION_JSON) 
				.content(asJsonString(p))
				).andDo( print() )
	    .andDo( print() )
	    .andExpect( status().isOk() )
	    .andExpect(content().string(containsString("imagen1.jpg") ) );

		
	}//PruebaPOST
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

	
	@Test
	@DisplayName("Prueba el método GET de productos con el id=1 y su contenido")
	public void pruebaUPDATE() throws Exception {
	    this.mockMvc.perform( put("/api/actividades/1").queryParam("imagen", "imagen1.jpg")  )
	    .andDo( print() )
	    .andExpect( status().isOk() )
	    .andExpect(content().string(containsString("Producto_1.jpg") ) );
	}//pruebaGET
	
	@Test
	@DisplayName("Prueba el método Delete de actividades con el id=1 y su contenido")
	@Disabled("Se deshabilita temporalmente para no borrar registros en cada prueba")
	public void pruebaDELETE() throws Exception {
	    this.mockMvc.perform( delete("/api/actividades/1") )
	    .andDo( print() )
	    .andExpect( status().isOk() )
	    .andExpect(content().string(containsString("Viajecito") ) );
	}//pruebaDELETE
	
	@Test
	@DisplayName("Prueba el método GET de actividades con el id=1 y su contenido")
	public void pruebaGET() throws Exception {
	    this.mockMvc.perform( get("/api/actividades/1") )
	    .andDo( print() )
	    .andExpect( status().isOk() )
	    .andExpect(content().string(containsString("imagen1.jpg") ) );
	}//pruebaGET
	
	
	//@Test
	//void contextLoads() {
	//}

}//class EcommercedbApplicationTest
