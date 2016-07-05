from django.contrib.auth.models import User

from rest_framework import serializers
from Spleez.models import Person, Activity, Address

class PersonSerializer(serializers.ModelSerializer):
    class Meta:
        model = Person
        fields = ('id', 'name', 'first_name', 'login', 'password', 'age')
        
class ActivitySerializer(serializers.ModelSerializer):
	class Meta:
		model = Activity
		fields = ('id', 'name', 'description', 'date', 'address_id', 'creator_id')
