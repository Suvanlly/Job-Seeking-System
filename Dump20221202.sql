-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: monjs
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `company_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(100) NOT NULL,
  `c_email` varchar(45) NOT NULL,
  `c_contact` varchar(45) NOT NULL,
  `c_address` varchar(45) NOT NULL,
  `c_city` varchar(45) NOT NULL,
  `c_state` varchar(45) NOT NULL,
  `c_post` varchar(45) NOT NULL,
  `c_country` varchar(45) NOT NULL,
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Monash','monash@uni.com','12341234','123 Monash Drive','Monash City','Victoria','1234','Australia');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_involvement`
--

DROP TABLE IF EXISTS `company_involvement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_involvement` (
  `user_id` int NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`company_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `comp_id_idx` (`company_id`),
  CONSTRAINT `fk_involve_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `fk_involve_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_involvement`
--

LOCK TABLES `company_involvement` WRITE;
/*!40000 ALTER TABLE `company_involvement` DISABLE KEYS */;
INSERT INTO `company_involvement` VALUES (1,1);
/*!40000 ALTER TABLE `company_involvement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_post`
--

DROP TABLE IF EXISTS `company_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_post` (
  `job_id` int NOT NULL,
  `company_id` int NOT NULL,
  PRIMARY KEY (`job_id`,`company_id`),
  KEY `pkfk_company_post_company_idx` (`company_id`),
  CONSTRAINT `pkfk_company_post_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  CONSTRAINT `pkfk_company_post_job` FOREIGN KEY (`job_id`) REFERENCES `job_post` (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_post`
--

LOCK TABLES `company_post` WRITE;
/*!40000 ALTER TABLE `company_post` DISABLE KEYS */;
INSERT INTO `company_post` VALUES (1,1),(2,1),(3,1);
/*!40000 ALTER TABLE `company_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_activity`
--

DROP TABLE IF EXISTS `job_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_activity` (
  `job_activity_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `job_id` int NOT NULL,
  `apply_date` date NOT NULL,
  PRIMARY KEY (`job_activity_id`),
  KEY `job_id_idx` (`job_id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `fk_activity_job` FOREIGN KEY (`job_id`) REFERENCES `job_post` (`job_id`),
  CONSTRAINT `fk_activity_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_activity`
--

LOCK TABLES `job_activity` WRITE;
/*!40000 ALTER TABLE `job_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_post`
--

DROP TABLE IF EXISTS `job_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_post` (
  `job_id` int NOT NULL AUTO_INCREMENT,
  `j_poster_id` int NOT NULL,
  `j_title` varchar(500) NOT NULL,
  `j_company` varchar(100) NOT NULL,
  `j_state` varchar(45) NOT NULL,
  `j_salary` int NOT NULL,
  `j_content` varchar(10000) NOT NULL,
  `j_created` date NOT NULL,
  `j_expiry` date NOT NULL,
  `j_visible` tinyint NOT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_post`
--

LOCK TABLES `job_post` WRITE;
/*!40000 ALTER TABLE `job_post` DISABLE KEYS */;
INSERT INTO `job_post` VALUES (1,1,'BUBBLY STAFF WANTED! NO EXPERIENCE NEEDED! WEEKLY BONUSES!! IMMEDIATE START!!','Monash','Victoria',80000,'- Must be available FULL TIME Monday- Friday, 9am-5:30pm\n\n \n\nWhat we\'re offering:\n\nFun vibes – containing weird and wonderful people, loud laughs, and a genuine, young, family-like culture.\nExtensive training and full support - we take training very seriously and will provide you with the industry\'s very best training\nAmazing growth prospects we can’t grow unless you do! Career progression and leadership opportunities \nTravel Australia on us – See places you’ve never heard off with the best team!\nAmazing Bonuses – Make it easier to save for your dreams,Business class flights anywhere in the world with our Pitching for prizes or join us on our beach house weekends away!\nStarting rate $26.73ph-$35.00ph plus uncapped commissions $$ and super.\n \n\nWhat do we look for?\n\nWe are currently looking for motivated, customer service agents looking to for a challenge to join our young energetic face to face team here in Melbourne!\n\n- Confident, bubbly people who love talking to new people!! \n\n- Enjoy working with a young, enthusiastic team!!\n\n- Willingness to learn, This role is what you make it! \n\n- People wanting to do something with meaning and want to make a positive impact \n\nThis is not an office job, you must love people and have personality! \n\n \n\nWho Are We? \n\nWe are Australia\'s fasted growing sales company! We are making big waves in the industry! We take pride in what we do and are looking for fun and friendly humans to grow and develop with us! \n\nWe are expert communicators, producing brand awareness and face to face sales on behalf of our clients and are known for investing in our people by ensuring career development through full training, support, and encouragement.\n\nNo Experience Necessary! APPLY NOW!! \n\nTo apply you must be 18+ and be permanent Australian resident or have full working rights','2022-12-01','2022-12-31',1),(2,1,'Data Entry Operators','Monash','Victoria',70000,'Our client located in Ravenhall is a world leader in business and document management. They have a diverse range of products, solutions and services to make it easier for businesses to reduce printing costs, cut down waste, streamline day-to-day processes and automate common tasks.\n\nThey are currently seeking skilled Data Entry Operators to join their close knit team.\n\nThis is an ongoing role working Day shift  9am - 5pm Monday to Friday.\n\nAs a data entry operator, your skills and abilities will be utilized by our client to ensure that the information being entered into their system is accurate and of the highest quality.\n\nYou will be required to learn a variety of campaigns so the ability to multi task is a must\n\nTo be successful for this role you must: \n\nHave fast and accurate Alpha data entry skills with a minimum of 50 wpm (word per minute) and accuracy of a minimum of 95%\nHave fast and accurate Numeric data entry skills with a minimum of 8,000ksph (keystrokes per hour) and accuracy of a minimum of 95%\nHave strong attention to detail\nHave the ability to reach daily targets and deadlines\nHave high computer knowledge and competency\n  *** Please note data entry applicants will be subject to undergo a typing test as part of the short listing process ***\n\nOther requirements: \n\nBe an Australian citizen\nHave or be willing to obtain a national police check and background check.\nWhy work with us?\n\nWeekly Pay\nWork close to home with on-site parking and cafeteria\nOn-going candidate care support by our agency with access to unique benefits and discounts platform\nCareer progression opportunities with cross training and view for permanency for the right candidate\nIf you feel you possess the necessary skills and experience, please express your interest with an updated CV by clicking the \'apply now\' button.\n\nPlease note due to the volume of applications only shortlisted candidates will be contacted.\n\nAustralian Staffing Agency acknowledges the Australian Aboriginal and Torres Strait Islander peoples as the first inhabitants of the nation and the traditional custodians of the lands where we live, learn and work. We pay our respects to ancestors and Elders, past and present. We are an equal opportunity employer and value diversity at our company. We do not discriminate on the basis of race, religion, colour, national origin, gender, sexual orientation, age, marital status, veteran status, or disability status.','2022-12-01','2022-12-31',1),(3,1,'Receptionist','Monash','Victoria',70000,'GymReceptionist.                                                 \n\nPart-time. 3.30 to 8 pm \n\nWe are looking for new team members who will share our enthusiasm and take on the duty of offering exceptional outcomes to members by inspiring them to achieve amazing things.   \n\nYou will play a crucial role in the success of Strikefit Boxing Gym and will oversee and assist in the developing of successful relationships with our Members and Personal Trainers. You will be engaging prospective members, encouraging them on their fitness journey, and celebrating their successes with them. They take overall responsibility for assisting in the running of their club, helping with growth targets, and helping create a clean, fun, and safe environment for their members to reach their goals. \n\nThis is an exciting time to join Strikefits boxing gym Burwood during this period of growth.\n\nThe role will involve a variety of tasks, including, - Membership processing, engagement, and sales\n\n \n\nApplicants will need the following skills.\n\n- Excellent communication and interpersonal skills to handle customer service.\n\nA mature and calm person with excellent customer skills and a high attention to detail.\n\n- The Ability to work autonomously and most importantly as part of a team\n\n- Basic computer skills such as using Microsoft programs\n\n- A desire to be part of the health and fitness industry.\n\n- Proven previous sales experience is essential.\n\nIn return, we offer an exciting and fun environment with a strong sense of community and friendship. \n\nAssisting members to improve their mental and physical well-being is very rewarding as you are involved in making a difference.\n\n \n\nIf this sounds like you email your resume to Mark@strikefit.com.au','2022-12-01','2022-12-31',1);
/*!40000 ALTER TABLE `job_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_skill`
--

DROP TABLE IF EXISTS `job_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_skill` (
  `job_id` int NOT NULL,
  `key_id` int NOT NULL,
  PRIMARY KEY (`job_id`,`key_id`),
  KEY `pkfk_job_skill_key_idx` (`key_id`),
  CONSTRAINT `pkfk_job_skill_job` FOREIGN KEY (`job_id`) REFERENCES `job_post` (`job_id`),
  CONSTRAINT `pkfk_job_skill_key` FOREIGN KEY (`key_id`) REFERENCES `keyword` (`key_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_skill`
--

LOCK TABLES `job_skill` WRITE;
/*!40000 ALTER TABLE `job_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keyword`
--

DROP TABLE IF EXISTS `keyword`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `keyword` (
  `key_id` int NOT NULL AUTO_INCREMENT,
  `keyword` varchar(100) NOT NULL,
  PRIMARY KEY (`key_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keyword`
--

LOCK TABLES `keyword` WRITE;
/*!40000 ALTER TABLE `keyword` DISABLE KEYS */;
INSERT INTO `keyword` VALUES (1,'http'),(2,'java'),(3,'python'),(4,'c++'),(5,'linux'),(6,'rust');
/*!40000 ALTER TABLE `keyword` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `message_id` int NOT NULL AUTO_INCREMENT,
  `message_type_id` int NOT NULL,
  `m_sender_id` int NOT NULL,
  `m_content` varchar(10000) NOT NULL,
  `m_read` tinyint NOT NULL,
  PRIMARY KEY (`message_id`,`message_type_id`),
  KEY `message_type_id_idx` (`message_type_id`),
  CONSTRAINT `message_type_id` FOREIGN KEY (`message_type_id`) REFERENCES `message_type` (`message_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` VALUES (1,1,2,'Dear Jane Smith,\n\nThank you for submitting an online application for the position of shift manager at French Bread Deli in Springfield, MA. We have looked over your application and would like to invite you to interview with our company as soon as possible.\n\nPlease visit the \"Jobs\" page on our website, www.frenchbreaddeli.com. Click on \"Schedule Interview\" in the top left corner of the page to schedule an interview in the upcoming weeks. You will be prompted for a password – type in “Mai Oui.” You will then be taken to our scheduling page, where you can select and reserve an interview time. These slots fill quickly, so we recommend that you schedule as soon as possible to receive your preferred time.\n\nIf you have any difficulties scheduling an interview, feel free to email me at mtaylor@frenchbreaddeli.com.\n\nBest,\n\nMadeline Taylor\n\n_______\n\nMadeline Taylor\n\nManager\nFrench Bread Deli\n100 Main Street\nSpringfield, MA, 01106\n555-555-5555\nmtaylor@frenchbreaddeli.com',0),(2,1,2,'Dear Jane,\nThank you for applying for the position of Financial Analyst.\nWe would like to invite you for an initial telephone interview with the head of our finance department, Mr Kenneth Lau.\nPlease note that this is an informal discussion to evaluate your suitability for the role. It also offers you an opportunity to ask any questions that you may have about the position.\nI would really appreciate it if you can confirm whether you would accept our invitation by July 5. Once you have confirmed your attendance, I can send over a calendar invite with all details you may require.\nThank you for your application, and I look forward to receiving your response.\nBest regards,\nPak Wong\nRecruiter\nMax Group of Companies',0),(3,1,1,'Dear Jane,\n\nWe have received your application for the marketing coordinator position at XYZ Company. Thank you very much for your interest in our organization.\n\nI would like to schedule a video call to discuss the position with you. Could you let me know your availability for early next week?\n\nWhen we have a time scheduled, I\'ll send you a calendar invitation to confirm the details with instructions for participating in the call.\n\nBest,\n\nTobias Cramer\nRecruiting Manager\nXYZ Company\ntobias.cramer@xyzcompany.com\n555-555-1212',0),(4,1,1,'Dear Jane Applicant,\n\nThank you for applying for the position of office administrator with ABC Company in Minneapolis, MN.\n\nWe would like to invite you to come to our office to interview for the position. Your interview has been scheduled for 1 pm on May 10, 2022, at 123 Main Street, Minneapolis, MN 55199.\n\nPlease call me at 651-555-6666 or email me at johnsmith@abccompany.com if you have any questions or need to reschedule.\n\nSincerely,\n\nJohn Smith\n\n_______\n\nJohn Smith\nRegional Manager\nABC Company\n123 Main Street, Minneapolis, MN 55199\n651-555-6666\njohnsmith@abccompany.com\n\n\n\n\n\n',0),(5,1,1,'Hi John,\n\nThank you so much for meeting with me today. I really enjoyed learning more about your career trajectory at CarRuns (and hearing what it was like to join as the fifth employee—so impressive!) and where you see the company going in the next couple years.\n\nTo follow up on our conversation about churned clients, I’ve attached a short deck I mocked up on my initial ideas for increasing renewals. Happy to discuss further if you see it being a helpful resource.\n\nI can tell CarRuns is a special place to work, and I would be thrilled to join such an innovative, hardworking, and passionate team of individuals. Please let me know if there’s anything else I can provide to make your hiring decision easier.\n\nBest regards,\n\nJane Smith',0),(6,1,2,'Hi Jane, \n\nThank you for applying to the Java Developer position at Active Engineer Pty ltd. \n\nAfter reviewing your application, we are excited to move forward with the interview process. \n\nWe would like to schedule a 40-minute phone call with Joe Culver, Senior Software Engineer. \n\nBelow are some date and time options: \n\n[6th, December – 1:00 pm] \n\n[7th, December – 3:00 pm] \n\n[8th, December – 2:00 pm] \n\nPlease reply directly to this email and let me know if you are available at any of the above times. From there, I’ll coordinate with Joe Culver and send you an email with a calendar invitation to confirm the date and time. \n\n\nBest, \n\nTom Smith \n\nSenior HR officer \n\n \n\n0422489343 ',0),(7,1,2,'Hello Jane\n\n  \nWe are glad to inform you that you have been selected for an in-person interview for the role of  IT Consultant with our company. Having gone through the preliminary discussion, we would like to invite you to meet us at our office.  \n\nBased on your availability, please confirm a time slot for us to schedule the interview. \n\n[6th, December – 1:00 pm] \n\n[7th, December – 3:00 pm] \n\n[8th, December – 2:00 pm] \n\n  \n\nHere are some relevant details to make the process quick and smooth for you. \n\nVenue Address: 141 Philip Street, Martin Place, Sydney NSW 2000 \n\nContact Person: John Smith \n\nInterview Duration: 1 hour \n\n  \n\nDo carry a copy of your resume and qualifications, along with a government identity proof for ease of access to our premises.  \n\nPlease confirm your availability by responding to this email. For any queries, feel free to call directly on the number provided below. \n\n  \n\nWarm Regards, \n\n \n\nTom Smith \n\nJunior HR officer \n\n0420668454 ',0),(8,1,2,'Hello Jane, \n\n  \n\nAt Smart Consulting we are always on the lookout for promising talent. For the position of UI Designer. After reviewing your application, we are excited to move forward with the interview process. \n\nAfter having gone through your resume, we find your credentials and experience quite relevant to the open position we are looking to hire for. It will be great if we can have a quick discussion wherein we can share more information on the role while getting to know you a bit better. \n\n  \n\nLet us know what a good time this week would be and we can connect then. \n\n  \n\nThanks and Regards, \n\nJack Martin \n\nSenior Recruiter \n\n0420555333 ',0),(9,1,2,'Hi Jane,\n\nThank you so much for meeting with me today. I really enjoyed learning more about your career trajectory at CarRuns (and hearing what it was like to join as the fifth employee—so impressive!) and where you see the company going in the next couple years.\n\nTo follow up on our conversation about churned clients, I’ve attached a short deck I mocked up on my initial ideas for increasing renewals. Happy to discuss further if you see it being a helpful resource.\n\nI can tell CarRuns is a special place to work, and I would be thrilled to join such an innovative, hardworking, and passionate team of individuals. Please let me know if there’s anything else I can provide to make your hiring decision easier.\n\nBest regards,\n\nJane Smith',0),(10,1,2,'Dear Jane,\n\nWe have received your application for the marketing coordinator position at XYZ Company. Thank you very much for your interest in our organization.\n\nI would like to schedule a video call to discuss the position with you. Could you let me know your availability for early next week?\n\nWhen we have a time scheduled, I\'ll send you a calendar invitation to confirm the details with instructions for participating in the call.\n\nBest,\n\nTobias Cramer\nRecruiting Manager\nXYZ Company\ntobias.cramer@xyzcompany.com\n555-555-1212',0);
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_inbox`
--

DROP TABLE IF EXISTS `message_inbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_inbox` (
  `message_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`message_id`,`user_id`),
  KEY `pkfk_inbox_user_idx` (`user_id`),
  CONSTRAINT `pkfk_inbox_message` FOREIGN KEY (`message_id`) REFERENCES `message` (`message_id`),
  CONSTRAINT `pkfk_inbox_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_inbox`
--

LOCK TABLES `message_inbox` WRITE;
/*!40000 ALTER TABLE `message_inbox` DISABLE KEYS */;
INSERT INTO `message_inbox` VALUES (1,1),(2,1),(3,1),(4,1),(6,1),(7,1),(8,1),(9,1),(10,1),(5,2);
/*!40000 ALTER TABLE `message_inbox` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_type`
--

DROP TABLE IF EXISTS `message_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message_type` (
  `message_type_id` int NOT NULL AUTO_INCREMENT,
  `message_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`message_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_type`
--

LOCK TABLES `message_type` WRITE;
/*!40000 ALTER TABLE `message_type` DISABLE KEYS */;
INSERT INTO `message_type` VALUES (1,'normal'),(2,'invitation');
/*!40000 ALTER TABLE `message_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_type_id` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `contact` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `post` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `education` varchar(45) DEFAULT NULL,
  `graduation` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_type_id`),
  KEY `user_type_id_idx` (`user_type_id`),
  CONSTRAINT `user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,2,'jsmith','123','Jane','Smith','jsmith@monjs.com','1234-12-12','12344321','123 Monash Avenue','Monash City','Victoria','1234','Australia',NULL,NULL),(2,1,'jdoe','123','John','Doe','jdoe@gmail.com','1234-12-12','12345678','123 Monash Street','Monash City','Victoria','1234','Australia','University','1234');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_skill`
--

DROP TABLE IF EXISTS `user_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_skill` (
  `user_id` int NOT NULL,
  `key_id` int NOT NULL,
  PRIMARY KEY (`key_id`,`user_id`),
  KEY `pkfk_skill_user_idx` (`user_id`),
  CONSTRAINT `pkfk_user_skill_key` FOREIGN KEY (`key_id`) REFERENCES `keyword` (`key_id`),
  CONSTRAINT `pkfk_user_skill_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_skill`
--

LOCK TABLES `user_skill` WRITE;
/*!40000 ALTER TABLE `user_skill` DISABLE KEYS */;
INSERT INTO `user_skill` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,3),(2,5),(2,6);
/*!40000 ALTER TABLE `user_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_type`
--

DROP TABLE IF EXISTS `user_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_type` (
  `user_type_id` int NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'job_seeker'),(2,'recruiter'),(3,'admin');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 17:01:34
