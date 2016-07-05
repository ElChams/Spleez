from django.db import models

# Create your models here.

class Person(models.Model):
	name = models.CharField(max_length=50)
	first_name = models.CharField(max_length=50)
	login = models.CharField(max_length=16)
	password = models.CharField(max_length=16)
	age = models.IntegerField()
	

class Address(models.Model):
	city = models.TextField()
	zipcode = models.IntegerField()
	street = models.TextField()
	number = models.IntegerField()

class Activity(models.Model):
	name = models.CharField(max_length=50)
	description = models.TextField()
	date = models.DateTimeField(auto_now_add=True, auto_now=False, verbose_name="Date de l'activité")
	address_id = models.ForeignKey(Address, on_delete=models.CASCADE)
	creator_id = models.ForeignKey(Person, on_delete=models.CASCADE)
	
	

	
	

