DESCRIPTION = "Pibert."  

require recipes-core/images/core-image-minimal.bb

GPU_MEM = "16"
DISABLE_SPLASH = "1"
BOOT_DELAY = "0"
BOOT_DELAY_MS = "0"
DISABLE_RPI_BOOT_LOGO = "1"

inherit extrausers

EXTRA_USERS_PARAMS = "usermod -P root root;"


# PREFERRED_PROVIDER_virtual/kernel = "linux-raspberrypi-rt"

## INHERIT += "update-rc.d"

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
    alsa-plugins \
    alsa-tools \
    alsa-utils \
    dropbear \
    python \
    systemd-analyze \
    pibertservice \
    python3-pip \
	"

#PACKAGES =+ "pibert"

#SPLASH = "psplash-raspberrypi"
#IMAGE_FEATURES += "ssh-server-dropbear"

#do_image_prepend() {
#    bb.warn("xxxxx")
#}

inherit systemd
DISTRO_FEATURES_append = "systemd"

DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
#VIRTUAL-RUNTIME_dev_manager = "systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
VIRTUAL-RUNTIME_syslog = "" 

SYSTEMD_SERVICE_${PN} = "pibert.service"
