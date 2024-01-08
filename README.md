🎉 ¡Hola! Soy Oscar Herrera y estoy emocionado de compartir que he culminado exitosamente una prueba como desarrollador de Kotlin. 🚀

Durante esta prueba, construí un sistema de pago online utilizando tecnologías como Jetpack Compose, Kotlin ViewModel, Dagger Hilt y SQLite para almacenar las transacciones del día. 📱💳

El sistema consta de 4 módulos principales:

#### 1️⃣ Primer Módulo: Almacenamiento y Generación de Token
En este módulo, me encargué de guardar en el almacenamiento del dispositivo Android el "commerceCode" y el "terminalCode". Además, implementé un inicio de sesión para generar el token necesario. Aunque el inicio de sesión está temporalmente deshabilitado y se ejecuta automáticamente para generar el token básico.

#### 2️⃣ Segundo Módulo: Realización de Pagos
En este módulo, desarrollé un formulario que incluye dos campos de entrada: "card" y "amount". Cada campo cuenta con validación para garantizar la integridad de los datos. El módulo se divide en varias secciones:

- **Sección 1:** Llenado de los campos de entrada.
- **Sección 2:** Validación de la transacción antes de enviarla al backend.
- **Sección 3:** Respuesta del backend y botones para finalizar o anular la transacción.
- **Sección 4:** Si se elige anular la transacción, se muestra un detalle de la misma y un botón para confirmar y consumir el API de anulación.
- **Sección 5:** Respuesta del backend con los detalles de la transacción eliminada.

#### 3️⃣ Tercer Módulo: Anulación de Transacciones
En este módulo, se brinda la opción de anular una transacción. Se proporcionan dos campos de entrada: "número de recibo" y "número de recibo". Además, se muestran dos secciones adicionales: una para confirmar la transacción que se va a anular y otra para mostrar los detalles de la transacción anulada.

#### 4️⃣ Cuarto Módulo: Listado de Transacciones
En este módulo, se listan todas las transacciones guardadas localmente y se ofrece la opción de anular una transacción específica. Cada vez que se anula una transacción, se elimina de la base de datos local.

Durante el desarrollo de este proyecto, utilicé la inyección de dependencias con Dagger Hilt para gestionar las dependencias de manera eficiente. Además, implementé la arquitectura MVVM (Model-View-ViewModel) para separar la lógica de negocio de la interfaz de usuario y facilitar el mantenimiento y la escalabilidad del sistema.

Estoy orgulloso del trabajo que realicé durante esta prueba y emocionado por la oportunidad de postularme como desarrollador de Kotlin. Espero tener la oportunidad de compartir más detalles sobre mi proyecto y aprender más sobre las oportunidades en su empresa.

¡Gracias por tu atención y consideración! 😊🙌

Recuerda que cada vez que ejecutamos el API de enviar pago, las transacciones se guardan en una base de datos local.