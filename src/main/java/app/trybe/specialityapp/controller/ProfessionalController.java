package app.trybe.specialityapp.controller;

import app.trybe.specialityapp.commons.ApplicationError;
import app.trybe.specialityapp.model.Professional;
import app.trybe.specialityapp.service.ProfessionalService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

/**
 * Class ProfessionalController.
 */
@Controller
@Path("/professional")
public class ProfessionalController {
  @Inject
  private ProfessionalService professionalService;

  /**
   * Method findAll.
   */
  @GET
  @Path("/all")
  public Response findAll() {
    try {
      return Response.ok(professionalService.findAll()).build();
    } catch (NotFoundException e) {
      ApplicationError error = new ApplicationError(Response.Status.NOT_FOUND, e.getMessage());
      return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
  }

  /**
   * Method findById.
   */
  @GET
  @Path("/{id}")
  public Response findById(@PathParam("id") Integer id) {
    try {
      return Response.ok(professionalService.findById(id)).build();
    } catch (NotFoundException e) {
      ApplicationError error = new ApplicationError(Response.Status.NOT_FOUND, e.getMessage());
      return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
  }

  /**
   * Method add.
   */
  @POST
  @Path("/add")
  public Response add(Professional professional) {
    try {
      professionalService.add(professional);
      return Response.status(Response.Status.CREATED).entity("Inserido").build();
    } catch (IllegalArgumentException e) {
      ApplicationError error = new ApplicationError(Response.Status.BAD_REQUEST, e.getMessage());
      return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
  }

  /**
   * Method update.
   */
  @PUT
  @Path("/edit/{id}")
  public Response update(@PathParam("id") Integer id, Professional professional) {
    try {
      professionalService.update(id, professional);
      return Response.ok(String.format("ID [%d] atualizado", id)).build();
    } catch (NotFoundException e) {
      ApplicationError error = new ApplicationError(Response.Status.NOT_FOUND, e.getMessage());
      return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
  }

  /**
   * Method delete.
   */
  @DELETE
  @Path("/delete/{id}")
  public Response delete(@PathParam("id") Integer id) {
    try {
      professionalService.delete(id);
      return Response.ok(String.format("ID [%d] removido", id)).build();
    } catch (NotFoundException e) {
      ApplicationError error = new ApplicationError(Response.Status.NOT_FOUND, e.getMessage());
      return Response.status(Response.Status.NOT_FOUND).entity(error).build();
    }
  }
}
