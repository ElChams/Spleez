from django.conf.urls import patterns, include, url
from django.contrib import admin

from Spleez import views

admin.autodiscover()
urlpatterns = patterns('',
    url(r'^admin/', include(admin.site.urls)),
    url(r'^activities/', views.activity_list),
    url(r'^activity/', views.activity_list),
	url(r'^user/(?P<login>\w+)/(?P<password>\w+)/$', views.person_detail),
)
