SUMMARY = "Install and start a systemd service"
SECTION = "examples"
# PACKAGES =+ "${PN}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://samplerbox.service \
"

inherit systemd

S = "${WORKDIR}"
PACKAGES =+ "samplerbox"

SYSTEMD_SERVICE_${PN} = "samplerbox.service"


do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/samplerbox.service ${D}${systemd_system_unitdir}
}

FILES_${PN} = "${systemd_system_unitdir}"

REQUIRED_DISTRO_FEATURES= "systemd"
