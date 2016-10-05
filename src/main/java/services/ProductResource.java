package services;

import Repositories.IProductRepo;
import Repositories.ProductRepo;
import app.Product;
import app.SingleProduct;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

/**
 * Created by Sander on 21-9-2016.
 */
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    IProductRepo productRepo = ProductRepo.getInstance();

    @Context
    UriInfo uriInfo;

    @GET
    public Response getProducts() {
        List<Product> products = productRepo.getProducts();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String id) {
        return Response.ok(productRepo.getProduct(id)).build();
    }

    @POST
    @Consumes("application/json")
    public Response addProduct(SingleProduct product) {
        productRepo.addProduct(product);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(product.getCode());
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") String id) {
        productRepo.deleteProduct(id);
        return Response.ok().build();

    }
}
