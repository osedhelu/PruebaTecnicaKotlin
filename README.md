🎉 ¡Hola! Soy Oscar Herrera y estoy emocionado de compartir que he culminado exitosamente una prueba como desarrollador de Kotlin. 🚀

Durante esta prueba, construí un sistema de pago online utilizando tecnologías como Jetpack Compose, Kotlin ViewModel, Dagger Hilt y SQLite para almacenar las transacciones del día. 📱💳

El sistema consta de 4 módulos principales:

1️⃣ El primer módulo se encarga de guardar en el almacenamiento del dispositivo Android el "commerceCode" y el "terminalCode". También implementé un inicio de sesión para generar el token necesario. Aunque el inicio de sesión está temporalmente deshabilitado y se ejecuta automáticamente para generar el token básico.

2️⃣ El segundo módulo permite realizar pagos. Cuenta con un formulario que incluye dos campos de entrada: "card" y "amount". Cada campo tiene validación. El módulo se divide en varias secciones:

Sección 1: Llenado de los campos de entrada.
Sección 2: Validación de la transacción antes de enviarla al backend.
Sección 3: Respuesta del backend y botones para finalizar o anular la transacción.
Sección 4: Si se elige anular la transacción, se muestra un detalle de la misma y un botón para confirmar y consumir el API de anulación.
Sección 5: Respuesta del backend con los detalles de la transacción eliminada.

3️⃣ En el tercer módulo, se brinda la opción de anular una transacción. Se proporcionan dos campos de entrada: "número de recibo" y "número de recibo". Además, se muestran dos secciones adicionales: una para confirmar la transacción que se va a anular y otra para mostrar los detalles de la transacción anulada.

4️⃣ El cuarto módulo lista todas las transacciones guardadas localmente y ofrece la opción de anular una transacción específica. Cada vez que se anula una transacción, se elimina de la base de datos local.

Estoy orgulloso del trabajo que realicé durante esta prueba y estoy emocionado por la oportunidad de postularme como desarrollador de Kotlin. ¡Espero tener la oportunidad de compartir más detalles sobre mi proyecto y aprender más sobre las oportunidades en su empresa!

¡Gracias por tu atención y consideración! 😊🙌

Recuerda que cada vez que ejecutamos el API de enviar pago, las transacciones se guardan en una base de datos local.
