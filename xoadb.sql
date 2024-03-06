-- Switch to master database
USE master;
GO

-- Drop the shophandmade database
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = N'shophandmade')
BEGIN
    ALTER DATABASE shophandmade SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE shophandmade;
END
