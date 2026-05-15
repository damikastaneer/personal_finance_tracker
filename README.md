# FinTrack

FinTrack is a modern personal finance tracker built with JavaFX.  
The application helps users manage their income, expenses, budgets, and savings goals while also serving as a learning project for software engineering, backend development, data engineering, and AI integration.

---

# Project Vision

FinTrack is designed to become more than a simple budgeting application.

The project combines:
- desktop application development
- backend API architecture
- authentication and security
- data engineering workflows
- analytics and reporting
- AI-assisted financial insights

The goal is to build a scalable financial platform while learning modern software engineering practices.

---

# Features

## Authentication
- User registration
- User login
- Password hashing
- Session management
- JWT authentication *(planned)*

---

## Dashboard
- Current balance overview
- Monthly income summary
- Monthly expense summary
- Recent transactions
- Financial statistics
- Visual charts and analytics

---

## Transaction Management
- Add transactions
- Edit transactions
- Delete transactions
- Transaction history
- Income and expense tracking
- Transaction categorization
- Search and filtering

### Transaction Fields
- amount
- type
- category
- date
- description

---

## Categories
Default categories include:
- Groceries
- Rent
- Transportation
- Entertainment
- Subscriptions
- Healthcare
- Education
- Salary
- Miscellaneous

Planned:
- Custom categories
- Category colors
- Category analytics

---

## Budget Management
- Monthly budgets per category
- Budget tracking
- Overspending warnings
- Remaining budget calculation

Example:
```text
Groceries: €250/month
Entertainment: €75/month
Transport: €100/month
```

---

## Savings Goals
- Create savings goals
- Track progress
- Goal deadlines
- Savings analytics

Example:
```text
Gaming PC
Goal: €1800
Saved: €650
Progress: 36%
```

---

## Statistics & Visualization
- Expense distribution charts
- Monthly spending trends
- Savings progress charts
- Budget analytics
- Financial summaries

Planned chart types:
- PieChart
- LineChart
- BarChart

---

# AI Assistant / LLM Agent

FinTrack will include an AI-powered financial assistant designed to help users understand and improve their financial habits.

The assistant will analyze financial data and provide natural language insights.

## Planned AI Features
- Spending pattern analysis
- Financial summaries
- Budget improvement suggestions
- Savings recommendations
- Transaction analysis
- Unusual spending detection
- Natural language financial Q&A

## Example Prompts

```text
Where did I spend the most money this month?
```

```text
How much did I spend on subscriptions?
```

```text
Compare my spending with last month.
```

```text
How can I save an extra €100 this month?
```

```text
Which categories are causing me to exceed my budget?
```

---

# Data Engineering Goals

FinTrack is also designed as a data engineering learning project.

The application will include financial analytics pipelines, reporting systems, and aggregated data processing.

## Planned Data Engineering Features
- ETL workflows
- Scheduled aggregation jobs
- Financial reporting
- Data transformation pipelines
- Analytics tables
- Data visualization
- CSV import/export
- Historical analytics
- Spending trend analysis

---

# Architecture

## Current Architecture

```text
JavaFX Client
      ↓
Service Layer
      ↓
DAO Layer
      ↓
SQLite Database
```

---

## Planned Full-Stack Architecture

```text
JavaFX Frontend
        ↓
REST API (Spring Boot)
        ↓
JWT Authentication
        ↓
Business Logic Layer
        ↓
Analytics & AI Services
        ↓
PostgreSQL Database
```

---

# Tech Stack

## Frontend
- Java
- JavaFX
- SceneBuilder
- CSS styling

---

## Backend *(planned)*
- Spring Boot
- REST APIs
- JWT Authentication
- BCrypt password hashing

---

## Database
### Current
- SQLite

### Planned
- PostgreSQL

---

## Data Engineering
- SQL
- ETL workflows
- Data aggregation
- Reporting systems
- Analytics pipelines

---

## AI / Machine Learning *(planned)*
- LLM integration
- Financial reasoning agent
- Spending prediction
- Personalized insights

---

# Security

Planned security features:
- Password hashing with BCrypt
- JWT authentication
- Protected API routes
- Role-based access control
- Secure database access
- User data isolation

---

# Planned Features

## Core Features
- Transaction editing
- Budget notifications
- Savings analytics
- Advanced statistics

---

## Backend Features
- REST API
- JWT authentication
- Cloud synchronization
- Multi-device support

---

## Data Engineering Features
- Scheduled reporting jobs
- Analytics database tables
- Data warehouse concepts
- CSV import/export
- Financial trend processing

---

## AI Features
- Financial assistant
- AI-generated monthly summaries
- Personalized saving advice
- Spending anomaly detection
- Smart budgeting recommendations

---

# Database Design

## Users

```text
users
- id
- username
- email
- password_hash
```

---

## Transactions

```text
transactions
- id
- user_id
- amount
- type
- category
- description
- date
```

---

## Budgets

```text
budgets
- id
- user_id
- category
- limit_amount
- month
```

---

## Saving Goals

```text
saving_goals
- id
- user_id
- name
- target_amount
- current_amount
- deadline
```

---

# Development Roadmap

## Phase 1 — MVP
- Login/Register
- SQLite database
- Transaction management
- Dashboard
- Basic statistics

---

## Phase 2 — Advanced Features
- Budget system
- Savings goals
- Charts and analytics
- Filtering and search

---

## Phase 3 — Backend Expansion
- Spring Boot API
- JWT authentication
- PostgreSQL migration
- REST architecture

---

## Phase 4 — Data Engineering
- ETL pipelines
- Aggregation systems
- Reporting engine
- Analytics processing

---

## Phase 5 — AI Integration
- LLM financial assistant
- AI insights
- Smart budgeting
- Spending analysis
- Prediction systems

---

# Installation

## Clone Repository

```bash
git clone https://github.com/damikastaneer/personal_finance_tracker.git
```

---

## Open Project

Recommended IDEs:
- IntelliJ IDEA
- VS Code
- Eclipse

---

## Run Application

Run the JavaFX application from the main class.

---

# Screenshots

Coming soon.

---

# Goals of the Project

The main goals of FinTrack are:
- improving software engineering skills
- practicing backend development
- learning data engineering concepts
- experimenting with AI integration
- building a professional portfolio project

---

# Author

Developed by Dami.
