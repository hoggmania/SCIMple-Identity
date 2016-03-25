package edu.psu.swe.scim.server.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import edu.psu.swe.scim.server.schema.Registry;
import edu.psu.swe.scim.spec.protocol.SchemaResource;
import edu.psu.swe.scim.spec.protocol.data.ListResponse;

public class SchemaResourceImpl implements SchemaResource {
  
  @Inject
  Registry registry;
  
  @Override
  public Response getAllSchemas(String filter) {

    if (filter != null) {
      return Response.status(Status.FORBIDDEN).build();
    }
    
    ListResponse response = new ListResponse();
    List<String> schemas = registry.getAllSchemas();
    
    return Response.status(Status.NOT_IMPLEMENTED).build();
  }

  @Override
  public Response getSchema(String uri) {
    
    String schema = registry.getSchemaDoc(uri);
    
    if (schema != null){
      return Response.ok(schema).build();
    }
    
    return Response.status(Status.NOT_FOUND).build();
  }
}