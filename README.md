# PawStay — Pet Boarding Management

A Java Swing desktop coursework project configured as an Apache NetBeans Maven project.

## Open the project
1. Extract `PawStay_NetBeans_Project.zip`.
2. Open Apache NetBeans and select **File → Open Project**.
3. Select the extracted `PawStay_NetBeans_Project` folder (the folder containing `pom.xml`).
4. Wait for Maven dependencies to resolve.
5. Right-click the project and choose **Clean and Build**.
6. Run the project. The entry point is `com.mycompany.boarding_center.Main`.

Requires JDK 17 or newer and Apache NetBeans with Java/Maven support. MySQL is needed for the database-backed Customer and Pet screens.

## Viewing the NetBeans GUI Builder Design tab
The GUI Builder stores a form's visual layout in a matching `.form` file. Keep each `.java` file next to its `.form` file.

1. Expand **Source Packages → com.mycompany.boarding_center**.
2. Open `design.java`, then select **Design** (next to **Source** and **History**) to view the login form.
3. The other form-backed screens are `dashboard.java`, `Customers.java`, `Pets.java`, `reserve.java`, `Staff.java`, `Billing.java`, and `display_board.java`.
4. To edit by drag-and-drop, open a form's **Design** view, use the **Palette** to add components, and use **Properties** to change text, colours, fonts, and other settings.
5. Let NetBeans update the generated `initComponents()` section and the matching `.form` file. Avoid editing generated code manually when making visual changes.

The separate coursework-guidelines document was not included in the supplied files, so this project is based on the supplied PawStay reference image and the source project that was uploaded.

## Demo sign-in
The starter login screen opens the dashboard using the supplied prototype flow. The demo username/password shown in the login form are `staff01` / `staff01`. Do not use real personal data in coursework screenshots.

## Database setup
1. Start MySQL (for example through XAMPP).
2. Run `database/pet_care_compat_schema.sql` in phpMyAdmin or the MySQL client to create the legacy `pet_care` tables used by the current Customer and Pet form code.
3. The separate `database/pawstay_schema.sql` describes the newer PawStay schema used by the newer service classes.
4. The legacy GUI form classes currently connect to MySQL at `localhost:3306` as user `root` with an empty password. Change the connection details in those classes if your local MySQL setup differs.

## Project structure
- `src/main/java/com/mycompany/boarding_center/` — Java source files and matching NetBeans `.form` files.
- `src/main/resources/` — images and icons.
- `database/` — SQL setup scripts.
- `reference-original-src/` — original source/assets retained for comparison with the active project.
- `pom.xml` — Maven dependencies and build configuration.

## Coursework note
Use this project as a working base, test each screen, and make sure you understand the components, event handlers, validation, and SQL operations before submitting or demonstrating it. The `.form` files let you inspect and edit the supported screens in NetBeans GUI Builder; they are not a substitute for understanding or documenting your own work.
