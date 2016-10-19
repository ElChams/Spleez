from django.contrib.auth.models import User
from django.http import Http404

from rest_framework import status
from rest_framework.decorators import api_view
from rest_framework.response import Response

from Spleez.serializers import PersonSerializer, ActivitySerializer
from Spleez.models import Person, Address, Activity


@api_view(['GET','POST'])
def activity_list(request):
	"""
	List or create an activity
	"""
	if request.method == 'GET':
		activities = Activity.objects.all()
		serializer = ActivitySerializer(activities, many=True)
		return Response(serializer.data)

	elif request.method == 'POST':
		print(request.data)
		serializer = ActivitySerializer(data=request.data)
		if serializer.is_valid():
			serializer.save()
			return Response(serializer.data, status=status.HTTP_201_CREATED)
		return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
	
@api_view(['GET','POST'])
def person_detail(request, login, password):
	"""
	Retrieve or update an activity
	"""
	try:
		person = Person.objects.get(login=login, password=password)
	except Person.DoesNotExist:
		return Response(status=status.HTTP_404_NOT_FOUND)
		
	if request.method == 'GET':
		serializer = PersonSerializer(person)
		result = serializer.data
		result["valid"] = True
		return Response(result)

	elif request.method == 'POST':
		serializer = PersonSerializer(activity, data=request.data)
		if serializer.is_valid():
			serializer.save()
			return Response(serializer.data)
		return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)
