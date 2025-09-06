# Hospital Patient Management System (HPMS):
Traditional hospital management systems rely heavily on physical records and manual processes, which leads to:

Improper data management and difficulty in tracking patient history.

Time-consuming appointment booking, often requiring patients to wait in long queues.

Increased workload for doctors and hospital staff in managing records manually.

Inefficient task handling for admins, resulting in wasted time and reduced productivity.

💡 Solution

The Hospital Patient Management System (HPMS) provides a web-based solution that:

Digitizes patient, doctor, and appointment records for easy access and management.

Enables patients to book appointments online, reducing waiting time.

Helps doctors manage appointments and prescriptions more efficiently.

Allows admins to streamline hospital operations by organizing departments, staff, and patient data in one place.

Improves overall productivity and ensures hospital staff can focus more on patient care instead of paperwork.

A Spring Boot + MySQL project that simulates real-world hospital workflows:
- Admin manages doctors, departments, and patients.
- Patients can book appointments with doctors.
- Doctors can manage appointments and issue prescriptions.

## Tech Stack
- Java 21
- Spring Boot
- MySQL
- Hibernate / JPA

## ERD
<img width="1126" height="819" alt="Screenshot (176)" src="https://github.com/user-attachments/assets/5d87d50d-e983-4930-a7d5-448b7596e373" />

# Features with examples
1. Patient:
   POST /addPatient : Request->Json
   {
    "age": 30,
    "gender": "male",
    "user": {
        "name": "Akshay",
        "email": "Akshay24@gmail.com",
        "password": "Akshay3442",
        "role": "patient"
    }
}

Response ->created status:200OK

# Request all patients data :
<img width="1419" height="836" alt="Screenshot (177)" src="https://github.com/user-attachments/assets/d49864f6-9e89-4ec0-8dbc-3822f5b51d35" />

2. Get All Department Doctor Details:
   Get /getAllDepartments
   Response:
   {
        "id": 52,
        "name": "cardiologist",
        "description": "heart related treatements",
        "doctors": 
            {
                "id": 1,
                "specialization": "cardiologist",
                "availability": "mon-fri",
                "user": {
                    "id": 2,
                    "name": "Rahul",
                    "email": "rahul21@gmail.com",
                    "role": "doctor"
                }
            },
         "id": 102,
         "name": "neurology",
        "description": "brain related treatements",
        "doctors": [
            {
                "id": 2,
                "specialization": "neurology",
                "availability": "mon-fri",
                "user": {
                    "id": 3,
                    "name": "Vishal",
                    "email": "vishal24@gmail.com",
                    "role": "doctor"
                }
            }
   }
   
