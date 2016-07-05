from django.conf.urls import patterns, include, url
from django.contrib import admin

from Spleez import views

admin.autodiscover()
urlpatterns = patterns('',
    url(r'^admin/', include(admin.site.urls)),
    url(r'^activities/', views.activities_list),
    url(r'^activities/(?P<pk>[0-9]+)/$', views.activity_detail),
	url(r'^user/(?P<login>\w+)/(?P<password>\w+)/$', views.person_detail),
)
