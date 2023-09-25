package shopx;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProyectoFinal {
    private static ArrayList<String> descripciones = new ArrayList<>();
    private static ArrayList<Double> precios = new ArrayList<>();
    private static ArrayList<Integer> stocks = new ArrayList<>();
    private static ArrayList<Integer> estados = new ArrayList<>();

    private static ArrayList<String> productosSeleccionados = new ArrayList<>();
    private static ArrayList<Double> preciosSeleccionados = new ArrayList<>();

    private static ArrayList<Integer> unidadesVendidas = new ArrayList<>();
    private static ArrayList<String> fechasVentas = new ArrayList<>();
    private static ArrayList<ArrayList<String>> detallesVentas = new ArrayList<>();
    private static ArrayList<Double> montosTotalesVentas = new ArrayList<>();

    public static void main(String[] args) {
        // Predefinimos 5 productos con sus precios, stock y estado en activo
        for (int i = 0; i < 5; i++) {
            descripciones.add("Producto " + (i + 1));
            precios.add(10.0 + i * 2);
            stocks.add(20 - i * 3);
            estados.add(1);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Mantener productos");
            System.out.println("2. Registrar nueva venta");
            System.out.println("3. Reporte de productos vendidos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    manejarProductos(scanner);
                    break;
                case 2:
                    registrarNuevaVenta(scanner);
                    break;
                case 3:
                    reporteProductosVendidos(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void manejarProductos(Scanner scanner) {
        while (true) {
            System.out.println("\nMantener Productos:");
            System.out.println("1. Listar productos");
            System.out.println("2. Buscar producto");
            System.out.println("3. Nuevo producto");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarProductos(scanner);
                    break;
                case 2:
                    buscarProducto(scanner);
                    break;
                case 3:
                    nuevoProducto(scanner);
                    break;
                case 4:
                    actualizarProducto(scanner);
                    break;
                case 5:
                    eliminarProducto(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    private static void listarProductos(Scanner scanner) {
        if (descripciones.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("\nLista de Productos:");
            System.out.printf("%-4s %-15s %-10s %-6s %-7s\n", "ID", "Descripción", "Precio (S/)", "Stock", "Estado");
            for (int i = 0; i < descripciones.size(); i++) {
                System.out.printf("%-4d %-15s %-10.2f %-6d %-7s\n", i, descripciones.get(i),
                        precios.get(i), stocks.get(i), (estados.get(i) == 1 ? "Activo" : "Inactivo"));
            }
        }

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();

        if (respuesta == 1) {
            return;
        } else if (respuesta == 0) {
            System.out.println("Gracias por usar el programa. ¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Respuesta no válida. Continuando con la operación...");
        }
    }

    private static void buscarProducto(Scanner scanner) {
        System.out.print("Ingrese una descripción para buscar productos: ");
        scanner.nextLine(); // Limpiar el buffer
        String descripcion = scanner.nextLine().toLowerCase();

        System.out.println("\nResultados de la búsqueda:");

        boolean encontrado = false;
        for (int i = 0; i < descripciones.size(); i++) {
            if (descripciones.get(i).toLowerCase().contains(descripcion)) {
                System.out.println("ID: " + i);
                System.out.println("Descripción: " + descripciones.get(i));
                System.out.println("Precio: S/" + precios.get(i));
                System.out.println("Stock: " + stocks.get(i));
                System.out.println("Estado: " + (estados.get(i) == 1 ? "Activo" : "Inactivo"));
                System.out.println();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron productos con la descripción proporcionada.");
        }

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        }
    }

    private static void nuevoProducto(Scanner scanner) {
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la descripción del nuevo producto: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio del nuevo producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el stock del nuevo producto: ");
        int stock = scanner.nextInt();

        descripciones.add(descripcion);
        precios.add(precio);
        stocks.add(stock);
        estados.add(1);

        System.out.println("Producto agregado correctamente.");

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        }
    }

    private static void actualizarProducto(Scanner scanner) {
        // Mostrar la lista de productos en filas
        System.out.println("\nLista de Productos para Actualizar:");
        System.out.printf("%-4s %-15s %-10s %-6s %-7s\n", "ID", "Descripción", "Precio (S/)", "Stock", "Estado");
        for (int i = 0; i < descripciones.size(); i++) {
            System.out.printf("%-4d %-15s %-10.2f %-6d %-7s\n", i, descripciones.get(i),
                    precios.get(i), stocks.get(i), (estados.get(i) == 1 ? "Activo" : "Inactivo"));
        }

        // Pedir al usuario que seleccione un producto a actualizar
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();

        if (id >= 0 && id < descripciones.size()) {
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese la nueva descripción del producto: ");
            String nuevaDescripcion = scanner.nextLine();

            System.out.print("Ingrese el nuevo precio del producto: ");
            double nuevoPrecio = scanner.nextDouble();

            System.out.print("Ingrese el nuevo stock del producto: ");
            int nuevoStock = scanner.nextInt();

            descripciones.set(id, nuevaDescripcion);
            precios.set(id, nuevoPrecio);
            stocks.set(id, nuevoStock);

            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("ID de producto no válido.");
        }

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        } else if (respuesta == 0) {
            System.out.println("Gracias por usar el programa. ¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Respuesta no válida. Continuando con la operación...");
        }
    }

    private static void eliminarProducto(Scanner scanner) {
        // Mostrar la lista de productos en filas
        System.out.println("\nLista de Productos para Eliminar:");
        System.out.printf("%-4s %-15s %-10s %-6s %-7s\n", "ID", "Descripción", "Precio (S/)", "Stock", "Estado");
        for (int i = 0; i < descripciones.size(); i++) {
            System.out.printf("%-4d %-15s %-10.2f %-6d %-7s\n", i, descripciones.get(i),
                    precios.get(i), stocks.get(i), (estados.get(i) == 1 ? "Activo" : "Inactivo"));
        }

        // Pedir al usuario que seleccione un producto a eliminar
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();

        if (id >= 0 && id < descripciones.size()) {
            estados.set(id, 0); // Cambiar estado a inactivo (0)
            System.out.println("Producto eliminado correctamente.");
        } else {
            System.out.println("ID de producto no válido.");
        }

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        } else if (respuesta == 0) {
            System.out.println("Gracias por usar el programa. ¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Respuesta no válida. Continuando con la operación...");
        }
    }

    private static void registrarNuevaVenta(Scanner scanner) {
        ArrayList<String> productosSeleccionados = new ArrayList<>();
        ArrayList<Double> preciosSeleccionados = new ArrayList<>();
        ArrayList<Integer> unidadesVendidas = new ArrayList<>();

        while (true) {
            // Mostrar la lista de productos activos con stock suficiente
            System.out.println("\nLista de Productos para Venta:");
            System.out.printf("%-4s %-15s %-10s %-6s\n", "ID", "Descripción", "Precio (S/)", "Stock");
            for (int i = 0; i < descripciones.size(); i++) {
                if (estados.get(i) == 1 && stocks.get(i) > 0) {
                    System.out.printf("%-4d %-15s %-10.2f %-6d\n", i, descripciones.get(i), precios.get(i), stocks.get(i));
                }
            }

            // Pedir al usuario que seleccione un producto para la venta
            System.out.print("Ingrese el ID del producto para agregar a la venta: ");
            int id = scanner.nextInt();

            if (id >= 0 && id < descripciones.size() && estados.get(id) == 1 && stocks.get(id) > 0) {
                // Verificar si el producto ya está en la lista de productos seleccionados
                if (productosSeleccionados.contains(descripciones.get(id))) {
                    System.out.println("El producto ya ha sido agregado a la venta.");
                    continue;
                }

                // Pedir la cantidad de unidades a vender
                System.out.print("Ingrese la cantidad de unidades a vender (disponibles: " + stocks.get(id) + "): ");
                int cantidad = scanner.nextInt();

                // Validar que la cantidad no supere el stock disponible
                if (cantidad > stocks.get(id)) {
                    System.out.println("La cantidad ingresada supera el stock disponible. Por favor, inténtelo nuevamente.");
                    continue;
                }

                // Agregar el producto seleccionado y su detalle a las listas
                productosSeleccionados.add(descripciones.get(id));
                preciosSeleccionados.add(precios.get(id));
                unidadesVendidas.add(cantidad);

                // Actualizar el stock del producto
                stocks.set(id, stocks.get(id) - cantidad);

                System.out.println("Producto agregado a la venta correctamente.");

                // Preguntar si el usuario desea agregar más productos
                System.out.print("¿Desea agregar más productos a la venta? (Sí: 1, No: 0): ");
                int respuesta = scanner.nextInt();
                if (respuesta == 0) {
                    break; // Salir del bucle si no se desean agregar más productos
                }
            } else {
                System.out.println("ID de producto no válido o producto sin stock suficiente.");
            }
        }

        // Mostrar el detalle de la venta si se han seleccionado productos
        if (!productosSeleccionados.isEmpty()) {
            System.out.println("\nDetalle de la Venta:");
            System.out.printf("%-15s %-10s %-6s %-10s\n", "Descripción", "Precio (S/)", "Unidades", "Sub Total");
            double montoTotal = 0.0;
            for (int i = 0; i < productosSeleccionados.size(); i++) {
                String descripcion = productosSeleccionados.get(i);
                double precioUnitario = precios.get(i);
                int unidades = unidadesVendidas.get(i);
                double subTotal = precioUnitario * unidades;

                System.out.printf("%-15s %-10.2f %-6d %-10.2f\n", descripcion, precioUnitario, unidades, subTotal);

                montoTotal += subTotal;
            }

            // Mostrar el monto total de la venta
            System.out.println("\nMonto Total de la Venta: S/" + montoTotal);

            // Pedir al usuario que ingrese el dinero recibido
            double montoRecibido = 0.0;
            do {
                System.out.print("Ingrese el monto recibido por el cliente: S/");
                montoRecibido = scanner.nextDouble();

                if (montoRecibido < montoTotal) {
                    System.out.println("El monto recibido es insuficiente. Por favor, ingrese un monto mayor o igual al total de la venta.");
                }
            } while (montoRecibido < montoTotal);

            // Calcular el vuelto y mostrarlo
            double vuelto = montoRecibido - montoTotal;
            System.out.println("Vuelto a entregar al cliente: S/" + vuelto);

            // Guardar la venta y su detalle
            Date fechaVenta = new Date();  // Fecha actual del sistema
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

            fechasVentas.add(formatoFecha.format(fechaVenta));
            detallesVentas.add(generarDetalleVenta(productosSeleccionados, preciosSeleccionados, unidadesVendidas));
            montosTotalesVentas.add(montoTotal);

            System.out.println("Venta registrada con éxito.");
        } else {
            System.out.println("No se han agregado productos a la venta. Cancelando la operación.");
        }

        // Consultar si el usuario quiere regresar al menú anterior
        System.out.print("¿Desea regresar al menú anterior? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        } else if (respuesta == 0) {
            System.out.println("Gracias por usar el programa. ¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Respuesta no válida. Continuando con la operación...");
        }
    }

    private static ArrayList<String> generarDetalleVenta(ArrayList<String> productos, ArrayList<Double> precios,ArrayList<Integer> unidades) {
        ArrayList<String> detalleVenta = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            String descripcion = productos.get(i);
            double precioUnitario = precios.get(i);
            int unidadesVendidas = unidades.get(i);

            double subtotalProducto = precioUnitario * unidadesVendidas;  // Subtotal por producto

            String detalleProducto = "Descripción: " + descripcion + ", Precio Unitario: S/" + precioUnitario +
                    ", Unidades: " + unidadesVendidas + ", Subtotal: S/" + subtotalProducto;
            detalleVenta.add(detalleProducto);
        }
        return detalleVenta;
    }

    private static void reporteProductosVendidos(Scanner scanner) {
        System.out.println("Reporte de Productos Vendidos:");
        System.out.println("ID\tFecha\t\tMonto Total");

        // Mostrar cabeceras de las ventas (fecha y monto total)
        for (int i = 0; i < fechasVentas.size(); i++) {
            System.out.printf("%d\t%s\tS/%.2f\n", i, fechasVentas.get(i), montosTotalesVentas.get(i));
        }

        System.out.print("Ingrese el ID de la venta para ver su detalle (-1 para regresar al menú principal): ");
        int idVenta = scanner.nextInt();

        if (idVenta >= 0 && idVenta < fechasVentas.size()) {
            // Mostrar el detalle de la venta seleccionada
            System.out.println("\nDetalle de la Venta (ID " + idVenta + "):");
            ArrayList<String> detalles = detallesVentas.get(idVenta);
            for (String detalle : detalles) {
                // Reemplazar saltos de línea con "\n" para una mejor presentación
                detalle = detalle.replace("\n", "\n  ");
                System.out.println("  " + detalle);
            }
        } else if (idVenta == -1) {
            return;  // Regresar al menú principal
        } else {
            System.out.println("ID de venta no válido. Volviendo al menú principal.");
        }

        // Preguntar si desea regresar al menú principal
        System.out.print("¿Desea regresar al menú principal? (Sí: 1, No: 0): ");
        int respuesta = scanner.nextInt();
        if (respuesta == 1) {
            return;
        } else if (respuesta == 0) {
            System.out.println("Gracias por usar el programa. ¡Hasta luego!");
            System.exit(0);
        } else {
            System.out.println("Respuesta no válida. Volviendo al menú principal.");
        }
    }


}
