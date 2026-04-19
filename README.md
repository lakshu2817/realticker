# realticker
SETUP STEPS:
BACKEND
Step 1: Go to backend folder
cd analysis
Step 2: Install dependencies (Maven build)
mvn clean install
Step 4: Run backend
mvn spring-boot:run
Backend runs on:
http://localhost:8080

2. FRONTEND SETUP (React)
Step 1: Go to frontend folder
cd frontend/realticker-frontend
Step 2: Install dependencies
npm install
Step 3: Start frontend
npm start
Frontend runs on:
http://localhost:3000

**ARCHITECHTURE DIAGRAM**
[ React Frontend]
        ↓
[ Spring Boot Backend ]
        ↓
[ Stock Service (Mock Data) ]
        ↓
[ AI Service (HuggingFace API / Fallback Logic) ]

**LLM Integration**

Initially integrated: HuggingFace Inference API
Attempted models:
google/flan-t5-base
bigscience/bloom-560m
